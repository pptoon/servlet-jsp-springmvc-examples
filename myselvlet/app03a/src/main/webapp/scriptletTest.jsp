<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriptlet example</title>
</head>
<body>
	<b>Http headers:</b>
	<br />
	<%-- first scriptlet --%>
	<%
		for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
			String header = e.nextElement();
			out.println(header + ": " + request.getHeader(header) + "<br/>");
		}
		String message = "Thank you.";
	%>
	<hr />
	<%-- second scriptlet --%>
	<%
		out.println(message);
	%>
</body>
</html>