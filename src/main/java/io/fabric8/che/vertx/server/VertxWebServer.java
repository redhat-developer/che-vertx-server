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
package io.fabric8.che.vertx.server;

import io.fabric8.che.vertx.handler.CreateServerHandler;
import io.fabric8.che.vertx.handler.CreateWorkspaceHandler;
import io.fabric8.che.vertx.handler.GetDeploymentConfigHandler;
import io.fabric8.che.vertx.handler.GetStackHandler;
import io.fabric8.che.vertx.handler.GetWorkspaceHandler;
import io.fabric8.che.vertx.handler.GetRouteHandler;
import io.fabric8.che.vertx.handler.StartWorkspaceHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class VertxWebServer extends AbstractVerticle {

	private static final int SERVER_PORT = 33333;

	private HttpServer httpServer;
	
	public static void main(String... args) {
		VertxWebServer server = new VertxWebServer();
		server.start();
	}
	
	@Override
	public void start() {
		Router router = Router.router(vertx);
		
		router.post(ServerEndpoints.SERVER).handler(new CreateServerHandler());
		router.get(ServerEndpoints.WORKSPACE).handler(new GetWorkspaceHandler());
		router.post(ServerEndpoints.WORKSPACE).handler(new CreateWorkspaceHandler());
		router.get(ServerEndpoints.STACK).handler(new GetStackHandler());
		router.get(ServerEndpoints.OPENSHIFT_ROUTE).handler(new GetRouteHandler());
		router.get(ServerEndpoints.OPENSHIFT_DEPLOYMENT_CONFIG).handler(new GetDeploymentConfigHandler());
		router.post(ServerEndpoints.START_WORKSPACE).handler(new StartWorkspaceHandler());
		
		httpServer = vertx.createHttpServer().requestHandler(router::accept).listen(SERVER_PORT);
	}
}
