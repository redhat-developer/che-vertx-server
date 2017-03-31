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

import io.fabric8.che.vertx.handler.CreateProjectHandler;
import io.fabric8.che.vertx.handler.CreateServerHandler;
import io.fabric8.che.vertx.handler.CreateWorkspaceHandler;
import io.fabric8.che.vertx.handler.DeleteWorkspaceHandler;
import io.fabric8.che.vertx.handler.GetDeploymentConfigHandler;
import io.fabric8.che.vertx.handler.GetGithubTokenHandler;
import io.fabric8.che.vertx.handler.GetOpenShiftTokenHandler;
import io.fabric8.che.vertx.handler.GetRouteHandler;
import io.fabric8.che.vertx.handler.GetStackHandler;
import io.fabric8.che.vertx.handler.GetStatusHandler;
import io.fabric8.che.vertx.handler.GetWorkspaceByIdHandler;
import io.fabric8.che.vertx.handler.GetWorkspaceHandler;
import io.fabric8.che.vertx.handler.StartWorkspaceHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
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
		
		// OpenShift routes
		router.get(ServerEndpoints.OPENSHIFT_ROUTE).handler(new GetRouteHandler());
		router.get(ServerEndpoints.OPENSHIFT_DEPLOYMENT_CONFIG).handler(new GetDeploymentConfigHandler());
		
		// Keycloak routes
		router.get(ServerEndpoints.KEYCLOAK_GITHUB_TOKEN).handler(new GetGithubTokenHandler());
		router.get(ServerEndpoints.KEYCLOAK_OS_TOKEN).handler(new GetOpenShiftTokenHandler());
		
		// Che Server routes
		router.post(ServerEndpoints.SERVER).handler(new CreateServerHandler());
		router.post(ServerEndpoints.WORKSPACE).handler(new CreateWorkspaceHandler());
		router.get(ServerEndpoints.STACK).handler(new GetStackHandler());
		router.get(ServerEndpoints.WORKSPACE).handler(new GetWorkspaceHandler());
		
		// Workspace routes
		router.get(ServerEndpoints.WORKSPACE_BY_ID).handler(new GetWorkspaceByIdHandler());
		router.post(ServerEndpoints.WORKSPACE_RUNTIME).handler(new StartWorkspaceHandler());
		router.delete(ServerEndpoints.WORKSPACE_RUNTIME).handler(new DeleteWorkspaceHandler());
		router.get(ServerEndpoints.WORKSPACE_STATUS).handler(new GetStatusHandler());
		router.post(ServerEndpoints.CREATE_WORKSPACE).handler(new CreateProjectHandler());
		
		router.route().failureHandler(failureRoutingContext -> {
			  HttpServerResponse response = failureRoutingContext.response();
			  response.setStatusCode(404).end("There is nothing! Pure nothing! Well... just nothing, really!");
			  response.end();
			});
		
		httpServer = vertx.createHttpServer().requestHandler(router::accept).listen(SERVER_PORT);
	}
}
