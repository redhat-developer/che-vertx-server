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

import static io.fabric8.che.vertx.constant.Constants.*;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public abstract class AbstractHandler implements Handler<RoutingContext> {
	
	public static String getResponse(String pathToJSONResponse) {
		String template = Utils.getTextFromFile(pathToJSONResponse);
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
