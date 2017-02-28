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

import io.fabric8.che.vertx.constant.Constants;

public class ServerEndpoints {
	
	public static final String SERVER = "/api/server";
	public static final String STACK = "/api/stack";
	public static final String WORKSPACE = "/api/workspace";
	public static final String OPENSHIFT = "/oapi/*";
	
	public static final String START_WORKSPACE = "/api/workspace/" + Constants.WORKSPACE_ID + "/runtime";

}
