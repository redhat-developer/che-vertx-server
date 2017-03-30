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

import io.fabric8.che.vertx.Constants;
import io.fabric8.che.vertx.Properties;
import io.fabric8.che.vertx.Response;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GetRouteHandler implements Handler<RoutingContext> {
	
	@Override
	public void handle(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		response.putHeader("Content-Type", "application/json").setChunked(true);
		String authHeader = routingContext.request().getHeader("Authorization");
		if (authHeader == null || !authHeader.contains(Properties.DEFAULT_AUTH_TOKEN)) {
			response.setStatusCode(203);
		} else {
			response.write(new Response().getResponse(Constants.GET_ROUTE_RESPONSE_TEMPLATE));
		}
		response.end();
	}
}
