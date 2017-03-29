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

import io.fabric8.che.vertx.handler.Utils;

public class Constants {

	// Variables in JSONs
	public static final String CHE_SERVER_URL_VAR = "\\{che.server.url\\}";
	public static final String OPENSHIFT_DEPLOYMENT_CONFIG_VAR = "\\{openshift.deployment.config\\}";
	public static final String OPENSHIFT_ROUTE_NAME_VAR = "\\{openshift.route.name\\}";
	public static final String OPENSHIFT_ROUTE_HOST_VAR = "\\{openshift.route.host\\}";
	public static final String OPENSHIFT_PROJECT_VAR = "\\{openshift.project\\}";
	public static final String STACK_NAME_VAR = "\\{stack.name\\}";
	
	// TODO replacement for those in Response
	public static final String WORKSPACE_NAME_VAR = "\\{workspace.name\\}";
	public static final String WORKSPACE_DESCRIPTION_VAR = "\\{workspace.description\\}";

	// Path to responses
	public static final String GET_OPENSHIFT_DEPLOYMENT_CONFIG_RESPONSE_TEMPLATE = Utils
			.getTextFromFile("GetDeploymentConfigResponse.json");
	public static final String GET_ROUTE_RESPONSE_TEMPLATE = Utils.getTextFromFile("GetRouteResponse.json");
	public static final String CREATE_WORKSPACE_RESPONSE_TEMPLATE = Utils.getTextFromFile("CreateWorkspaceResponse.json");
	public static final String CREATE_PROJECT_RESPONSE_TEMPLATE = Utils.getTextFromFile("CreateProjectResponse.json");
	public static final String GET_WORKSPACE_RESPONSE_TEMPLATE = Utils.getTextFromFile("GetWorkspaceResponse.json");
	public static final String GET_WORKSPACE_BY_ID_RESPONSE_TEMPLATE = Utils.getTextFromFile("GetWorkspaceByIdResponse.json");
	public static final String GET_STACK_RESPONSE_TEMPLATE = Utils.getTextFromFile("GetStackResponse.json");
	public static final String START_WORKSPACE_RESPONSE_TEMPLATE = Utils.getTextFromFile("StartWorkspaceResponse.json");
	public static final String GET_WORKSPACE_STATUS_RESPONSE_TEMPLATE = Utils.getTextFromFile("GetStatusResponse.json");

}
