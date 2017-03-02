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

import io.fabric8.che.vertx.constant.Constants;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GetDeploymentConfigHandler extends AbstractHandler {
	
	@Override
	public void handle(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		response.putHeader("Content-Type", "application/json").setChunked(true);
		response.write(getResponse(Constants.GET_OPENSHIFT_DEPLOYMENT_CONFIG_RESPONSE_PATH));
		response.end();
	}
}
