/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe;

import org.ralasafe.util.Startup;

public class StartService {
	public static void startup() {
		Startup.startup(
				"D:/apache-tomcat-5.5.20/webapps/zh-demo/WEB-INF/ralasafe",
				"D:/apache-tomcat-5.5.20/webapps/zh-demo/xml");
	}
}
