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

import static io.fabric8.che.vertx.Constants.*;

import io.fabric8.che.vertx.handler.Utils;

public class Response {

	public String getResponse(String template) {
		template = template.replaceAll(CHE_SERVER_URL_VAR,
				Utils.getProperty(Properties.CHE_SERVER_URL_PROPERTY, Properties.DEFAULT_CHE_SERVER_URL));
		template = template.replaceAll(OPENSHIFT_DEPLOYMENT_CONFIG_VAR, Utils
				.getProperty(Properties.OPENSHIFT_DEPLOYMENT_CONFIG_PROPERTY, Properties.DEFAULT_DEPLOYMENT_CONFIG));
		template = template.replaceAll(OPENSHIFT_ROUTE_NAME_VAR,
				Utils.getProperty(Properties.OPENSHIFT_ROUTE_NAME_PROPERTY, Properties.DEFAULT_OPENSHIFT_ROUTE_NAME));
		template = template.replaceAll(OPENSHIFT_ROUTE_HOST_VAR,
				Utils.getProperty(Properties.OPENSHIFT_ROUTE_HOST_PROPERTY, Properties.DEFAULT_OPENSHIFT_ROUTE_HOST));
		template = template.replaceAll(OPENSHIFT_PROJECT_VAR,
				Utils.getProperty(Properties.OPENSHIFT_PROJECT_PROPERTY, Properties.DEFAULT_OPENSHIFT_PROJECT));
		
		// tmp, TODO - more get workspace name and description from request and pass it to response
		template = template.replaceAll(WORKSPACE_NAME_VAR, "vertxworkspace");
		template = template.replaceAll(WORKSPACE_DESCRIPTION_VAR, "https://github.com/mlabuda/vertx-with-che.git#master");
		return template;
	}
}
