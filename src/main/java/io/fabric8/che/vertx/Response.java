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

import io.fabric8.che.vertx.constant.Constants;

public class Response {

	public static final String CREATE_WORKSPACE = Utils.getTextFromFile(Constants.CREATE_WORKSPACE_RESPONSE_PATH);
	public static final String GET_OPENSHIFT_DEPLOYMENT_CONFIG = Utils
			.getTextFromFile(Constants.GET_OPENSHIFT_DEPLOYMENT_CONFIG_RESPONSE_PATH);
	public static final String GET_ROUTE = Utils.getTextFromFile(Constants.GET_ROUTE_RESPONSE_PATH);
	public static final String GET_STACK = Utils.getTextFromFile(Constants.GET_STACK_RESPONSE_PATH);
	public static final String GET_WORKSPACE = Utils.getTextFromFile(Constants.GET_WORKSPACE_RESPONSE_PATH);
	public static final String START_WORKSPACE = Utils.getTextFromFile(Constants.START_WORKSPACE_RESPONSE_PATH);
}
