/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.demo;

import org.ralasafe.db.DBPower;

import java.sql.Connection;

public class DemoUtil {
	
	public static Connection getConnection() {
		return DBPower.getConnection(DBPower.getDefaultAppDsName());
	}

//	public static String getMessage(Locale locale, String key) {
//		return ResourceBundle.getBundle("demo", locale).getString(key);
//	}
//
//	public static String getMessage(Locale locale, String key, String argument) {
//		ResourceBundle rb = ResourceBundle.getBundle("demo", locale);
//		return MessageFormat.format(rb.getString(key),
//				new Object[] { argument });
//	}
}
