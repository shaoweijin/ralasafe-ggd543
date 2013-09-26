<%
    /**
     * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
     * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
     */
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@page import="org.ralasafe.WebRalasafe" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="org.ralasafe.demo.Privilege" %>
<%@page import="java.util.Locale" %>
<%@page import="java.util.Random" %>
<html>
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" media="screen" href="../css/ralasafe.css"/>
    <title>功能菜单</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<div class="smallContainer">
    <table title="Menu">
        <thead>
        <tr>
            <th bgcolor="#F4F4F4">
                <h1>功能菜单</h1>
            </th>
        </tr>
        </thead>

        <%
            if (WebRalasafe.hasPrivilege(request, Privilege.QUERY_EMPLOYEE)) {
        %>
        <tr>
            <td><a href="employee">
                <h2>员工管理</h2>
            </a></td>
        </tr>
        <%
            }
        %>

        <%
            if (WebRalasafe.hasPrivilege(request, Privilege.LOAN)) {
        %>
        <tr>
            <td><a href="loanMoney">
                <h2>贷款管理</h2>
            </a></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td><a href="demoLogout">
                <h2>Logout</h2>
            </a></td>
        </tr>
    </table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>