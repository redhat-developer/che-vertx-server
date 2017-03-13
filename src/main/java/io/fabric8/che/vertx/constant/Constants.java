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
package io.fabric8.che.vertx.constant;

import io.fabric8.che.vertx.handler.Utils;

public class Constants {

	// Execution parameters / properties
	public static final String CHE_SERVER_URL_PROPERTY = "cheServerURL";
	public static final String OPENSHIFT_DEPLOYMENT_CONFIG_PROPERTY = "openshiftDeploymentConfig";
	public static final String OPENSHIFT_ROUTE_NAME_PROPERTY = "openshiftRouteName";
	public static final String OPENSHIFT_ROUTE_HOST_PROPERTY = "openshiftRouteHost";
	public static final String OPENSHIFT_PROJECT_PROPERTY = "openshiftProject";
	public static final String WORKSPACE_ID_PROPERTY = "workspaceId";
	public static final String WORKSPACE_NAME_PROPERTY = "workspaceName";
	public static final String STACK_ID_PROPERTY = "stackId";
	public static final String STACK_NAME_PROPERTY = "stackName";
	
	// Variables in JSONs
	public static final String CHE_SERVER_URL_VAR = "\\{che.server.url\\}";
	public static final String OPENSHIFT_DEPLOYMENT_CONFIG_VAR = "\\{openshift.deployment.config\\}";
	public static final String OPENSHIFT_ROUTE_NAME_VAR = "\\{openshift.route.name\\}";
	public static final String OPENSHIFT_ROUTE_HOST_VAR = "\\{openshift.route.host\\}";
	public static final String OPENSHIFT_PROJECT_VAR = "\\{openshift.project\\}";
	public static final String WORKSPACE_ID_VAR = "\\{ws.id\\}";
	public static final String WORKSPACE_NAME_VAR = "\\{ws.name\\}";
	public static final String STACK_ID_VAR = "\\{stack.id\\}";
	public static final String STACK_NAME_VAR = "\\{stack.name\\}";
	
	// Path to responses
	public static final String GET_OPENSHIFT_DEPLOYMENT_CONFIG_RESPONSE_FILE = "GetDeploymentConfigResponse.json";
	public static final String GET_ROUTE_RESPONSE_FILE = "GetRouteResponse.json";
	public static final String CREATE_WORKSPACE_RESPONSE_FILE = "CreateWorkspaceResponse.json";
	public static final String GET_WORKSPACE_RESPONSE_FILE = "GetWorkspaceResponse.json";
	public static final String GET_STACK_RESPONSE_FILE = "GetStackResponse.json";
	public static final String START_WORKSPACE_RESPONSE_FILE = "StartWorkspaceResponse.json";
	
	// Default values
	public static final String DEFAULT_CHE_SERVER_URL = "http://localhost:33333";
	public static final String DEFAULT_DEPLOYMENT_CONFIG = "che";
	public static final String DEFAULT_OPENSHIFT_ROUTE_NAME = "che";
	public static final String DEFAULT_OPENSHIFT_ROUTE_HOST = "localhost:33333";
	public static final String DEFAULT_OPENSHIFT_PROJECT = "che";
	public static final String DEFAULT_WORKSPACE_ID = "chevertxwsid13";
	public static final String DEFAULT_WORKSPACE_NAME = "vertx-with-che";
	public static final String DEFAULT_STACK_ID = "default-vertx-stack";
	public static final String DEFAULT_STACK_NAME = "vertx_stack";
	
	// Used values
	public static final String CHE_SERVER_URL = Utils.getProperty(CHE_SERVER_URL_PROPERTY, DEFAULT_CHE_SERVER_URL);
	public static final String OPENSHIFT_DEPLOYMENT_CONFIG = Utils.getProperty(OPENSHIFT_DEPLOYMENT_CONFIG_PROPERTY, DEFAULT_DEPLOYMENT_CONFIG);
	public static final String OPENSHIFT_ROUTE_NAME = Utils.getProperty(OPENSHIFT_ROUTE_NAME_PROPERTY, DEFAULT_OPENSHIFT_ROUTE_NAME);
	public static final String OPENSHIFT_ROUTE_HOST = Utils.getProperty(OPENSHIFT_ROUTE_HOST_PROPERTY, DEFAULT_OPENSHIFT_ROUTE_HOST);
	public static final String OPENSHIFT_PROJECT = Utils.getProperty(OPENSHIFT_PROJECT_PROPERTY, DEFAULT_OPENSHIFT_PROJECT);
	public static final String WORKSPACE_ID = Utils.getProperty(WORKSPACE_ID_PROPERTY, DEFAULT_WORKSPACE_ID);
	public static final String WORKSPACE_NAME = Utils.getProperty(WORKSPACE_NAME_PROPERTY, DEFAULT_WORKSPACE_NAME);
	public static final String STACK_ID = Utils.getProperty(STACK_ID_PROPERTY, DEFAULT_STACK_ID);
	public static final String STACK_NAME = Utils.getProperty(STACK_NAME_PROPERTY, DEFAULT_STACK_NAME);
	
}
