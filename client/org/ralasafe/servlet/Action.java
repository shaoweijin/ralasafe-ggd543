package org.ralasafe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Action {
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException{
		
	}

	protected void doPost( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
	}
}
