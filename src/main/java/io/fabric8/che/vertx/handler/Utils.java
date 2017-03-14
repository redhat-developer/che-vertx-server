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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Utils {

	public static String getTextFromFile(String resourceFile) {
		StringBuilder sb = new StringBuilder();
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(classloader.getResourceAsStream(resourceFile), StandardCharsets.UTF_8));) {
			reader.lines().forEach(line -> sb.append(line));
		} catch (IOException e) {
			throw new RuntimeException("Cannot read file with JSON " + e.getStackTrace());
		}
		return sb.toString();
	}

	/**
	 * Gets at first JVM system property. If not found, try env. var and return value for it
	 * 
	 * @param propertyName
	 * @param defaultValue
	 * @return property/env var value
	 */
	public static String getProperty(String propertyName, String defaultValue) {
		String property = System.getProperty(propertyName);
		if (property == null || property.isEmpty()) {
			property = System.getenv(propertyName);
		}
		if (property == null || property.isEmpty()) {
			return defaultValue;
		} else {
			return property;
		}
	}
}
