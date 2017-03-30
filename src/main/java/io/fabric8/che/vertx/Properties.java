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

public class Properties {
	
	// Execution parameters / properties
	public static final String CHE_SERVER_URL_PROPERTY = "VERTX_CHE_SERVER_URL";
	public static final String OPENSHIFT_ROUTE_HOST_PROPERTY = "VERTX_OS_ROUTE_HOST";
	
	public static final String OPENSHIFT_PROJECT_PROPERTY = "VERTX_OS_PROJECT";
	
	public static final String OPENSHIFT_DEPLOYMENT_CONFIG_PROPERTY = "VERTX_DC";
	public static final String OPENSHIFT_ROUTE_NAME_PROPERTY = "VERTX_OS_ROUTE_NAME";
	
	// Default values
	public static final String DEFAULT_CHE_SERVER_URL = "http://localhost:33333";
	public static final String DEFAULT_OPENSHIFT_ROUTE_HOST = "localhost:33333";
	
	public static final String DEFAULT_OPENSHIFT_PROJECT = "eclipse-che";
	
	public static final String DEFAULT_DEPLOYMENT_CONFIG = "che";
	public static final String DEFAULT_OPENSHIFT_ROUTE_NAME = "che-host";
	
	public static final String DEFAULT_AUTH_TOKEN = "Bearer customtoken";
}
