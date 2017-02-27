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
package io.fabric8.che.vertx.handler;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class OpenShiftHandler implements Handler<RoutingContext> {
	
	private static final String pathToJSONResponse = "src/main/resources/GetRouteResponse.json";
	
	private static final String DEFAULT_OPENSHIFT_ROUTE_NAME = "che-host";
	private static final String OPENSHIFT_ROUTE_NAME = getRouteName();
	private static final String DEFAULT_OPENSHIFT_ROUTE_HOST = "localhost:33333";
	private static final String OPENSHIFT_ROUTE_HOST = getRouteHost();
	private static final String DEFAULT_OPENSHIFT_PROJECT = "online-tennant";
	private static final String OPENSHIFT_PROJECT = getProject();
	
	private static final String OPENSHIFT_ROUTE_NAME_VAR = "\\{openshift.route.name\\}";
	private static final String OPENSHIFT_ROUTE_HOST_VAR = "\\{openshift.route.host\\}";
	private static final String OPENSHIFT_PROJECT_VAR = "\\{openshift.project\\}";
	
	@Override
	public void handle(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		response.putHeader("Content-Type", "application/json").setChunked(true);
		response.write(getResponse());
		response.end();
	}

	private static String getResponse() {
		String template = Utils.getTextFromFile(pathToJSONResponse);
		template = template.replaceAll(OPENSHIFT_PROJECT_VAR, OPENSHIFT_PROJECT);
		template = template.replaceAll(OPENSHIFT_ROUTE_NAME_VAR, OPENSHIFT_ROUTE_NAME);
		template = template.replaceAll(OPENSHIFT_ROUTE_HOST_VAR, OPENSHIFT_ROUTE_HOST);
		return template;
	}

	private static String getRouteName() {
		return getProperty("openshiftRouteName", DEFAULT_OPENSHIFT_ROUTE_NAME);
	}
	
	private static String getRouteHost() {
		return getProperty("openshiftRouteHost", DEFAULT_OPENSHIFT_ROUTE_HOST);
	}
	
	private static String getProject() {
		return getProperty("openshiftProject", DEFAULT_OPENSHIFT_PROJECT);
	}
	
	private static String getProperty(String propertyName, String defaultValue) {
		String property = System.getProperty(propertyName);
		if (property == null || property.isEmpty()) {
			return defaultValue;
		} else {
			return property;
		}
	}
	
}
