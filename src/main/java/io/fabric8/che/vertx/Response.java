/******************************************************************************* 
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package io.fabric8.che.vertx;

import static io.fabric8.che.vertx.constant.Constants.CHE_SERVER_URL;
import static io.fabric8.che.vertx.constant.Constants.CHE_SERVER_URL_VAR;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_DEPLOYMENT_CONFIG;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_DEPLOYMENT_CONFIG_VAR;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_PROJECT;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_PROJECT_VAR;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_ROUTE_HOST;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_ROUTE_HOST_VAR;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_ROUTE_NAME;
import static io.fabric8.che.vertx.constant.Constants.OPENSHIFT_ROUTE_NAME_VAR;
import static io.fabric8.che.vertx.constant.Constants.STACK_ID;
import static io.fabric8.che.vertx.constant.Constants.STACK_ID_VAR;
import static io.fabric8.che.vertx.constant.Constants.STACK_NAME;
import static io.fabric8.che.vertx.constant.Constants.STACK_NAME_VAR;
import static io.fabric8.che.vertx.constant.Constants.WORKSPACE_ID;
import static io.fabric8.che.vertx.constant.Constants.WORKSPACE_ID_VAR;
import static io.fabric8.che.vertx.constant.Constants.WORKSPACE_NAME;
import static io.fabric8.che.vertx.constant.Constants.WORKSPACE_NAME_VAR;

import io.fabric8.che.vertx.constant.Constants;
import io.fabric8.che.vertx.handler.Utils;

public class Response {

	public static final String CREATE_WORKSPACE = getResponse(Constants.CREATE_WORKSPACE_RESPONSE_FILE);
	public static final String GET_OPENSHIFT_DEPLOYMENT_CONFIG = getResponse(Constants.GET_OPENSHIFT_DEPLOYMENT_CONFIG_RESPONSE_FILE);
	public static final String GET_ROUTE = getResponse(Constants.GET_ROUTE_RESPONSE_FILE);
	public static final String GET_STACK = getResponse(Constants.GET_STACK_RESPONSE_FILE);
	public static final String GET_WORKSPACE = getResponse(Constants.GET_WORKSPACE_RESPONSE_FILE);
	public static final String START_WORKSPACE = getResponse(Constants.START_WORKSPACE_RESPONSE_FILE);
	
	public static String getResponse(String responseFile) {
		String template = Utils.getTextFromFile(responseFile);
		template = template.replaceAll(CHE_SERVER_URL_VAR, CHE_SERVER_URL);
		template = template.replaceAll(OPENSHIFT_DEPLOYMENT_CONFIG_VAR, OPENSHIFT_DEPLOYMENT_CONFIG);
		template = template.replaceAll(OPENSHIFT_ROUTE_NAME_VAR, OPENSHIFT_ROUTE_NAME);
		template = template.replaceAll(OPENSHIFT_ROUTE_HOST_VAR, OPENSHIFT_ROUTE_HOST);
		template = template.replaceAll(OPENSHIFT_PROJECT_VAR, OPENSHIFT_PROJECT);
		template = template.replaceAll(WORKSPACE_ID_VAR, WORKSPACE_ID);
		template = template.replaceAll(WORKSPACE_NAME_VAR, WORKSPACE_NAME);
		template = template.replaceAll(STACK_ID_VAR, STACK_ID);
		template = template.replaceAll(STACK_NAME_VAR, STACK_NAME);
		return template;
	}
}
