#!/bin/bash

###
# #%L
# che-vertx-server
# %%
# Copyright (C) 2017 Red Hat, Inc.
# %%
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# #L%
###

cat jenkins-env | grep RHCHEBOT_DOCKER_HUB_PASSWORD > inherit-env
. inherit-env

yum -y update
yum -y install centos-release-scl java-1.8.0-openjdk-devel docker
yum -y install rh-maven33

VERTX_SERVER_IMAGE_NAME="rhche/che-vertx-server"
VERTX_SERVER_IMAGE_TAG="nightly"
VERTX_SERVER_IMAGE="${VERTX_SERVER_IMAGE_NAME}:${VERTX_SERVER_IMAGE_TAG}"

systemctl start docker

scl enable rh-maven33 'mvn clean package -B'

if [ $? -eq 0 ]; then

  docker build -t ${VERTX_SERVER_IMAGE} .

  if [ $? -ne 0 ]; then
    echo 'Docker Build Failed!'
    exit 2
  fi

  docker login -u rhchebot -p $RHCHEBOT_DOCKER_HUB_PASSWORD -e noreply@redhat.com
  docker push ${VERTX_SERVER_IMAGE}

else
  echo 'Build Failed!'
  exit 1
fi
