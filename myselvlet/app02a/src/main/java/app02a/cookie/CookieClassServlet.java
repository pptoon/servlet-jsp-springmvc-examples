package app02a.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fatcat
 */
@WebServlet(name = "CookieClassServlet", urlPatterns = { "/cookieClass" })
public class CookieClassServlet extends HttpServlet {
	private static final long serialVersionUID = 837369L;

	private String[] methods = { "clone", "getComment", "getDomain", "getMaxAge", "getName", "getPath", "getSecure",
			"getValue", "getVersion", "isHttpOnly", "setComment", "setDomain", "setHttpOnly", "setMaxAge", "setPath",
			"setSecure", "setValue", "setVersion" };

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		Cookie maxRecordsCookie = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("maxRecords".equals(cookie.getName())) {
					maxRecordsCookie = cookie;
					break;
				}
			}
		}
		// 设置默认每页记录数为5
		int maxRecords = 5; 
		if (maxRecordsCookie != null) {
			try {
				maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
			} catch (NumberFormatException e) {
				// 什么都不干，就用默认的每页最大记录数
			}
		}

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(
				"<html>"
				+ "<head>"
				+ "	<title>Cookie Class</title>"
				+ "</head>"
				+ "<body>" + PreferenceServlet.MENU
				+ "	<div>Here are some of the methods in " + "javax.servlet.http.Cookie");
		writer.print("<ul>");

		for (int i = 0; i < maxRecords; i++) {
			writer.print("<li>" + methods[i] + "</li>");
		}
		writer.print("</ul>");
		writer.print("</div></body></html>");
	}
}