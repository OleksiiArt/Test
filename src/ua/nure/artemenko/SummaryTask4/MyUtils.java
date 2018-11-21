package ua.nure.artemenko.SummaryTask4;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.artemenko.SummaryTask4.db.Role;
import ua.nure.artemenko.SummaryTask4.db.entity.User;

public class MyUtils {
	public static final String ATT_LOGIN_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_LOGIN = "ATTRIBUTE_FOR_STORE_LOGIN_IN_COOKIE";

	// Store Connection in request attribute.
	// (Information stored only exist during requests)
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_LOGIN_CONNECTION, conn);
	}

	// Get the Connection object has been stored in attribute of the request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_LOGIN_CONNECTION);
		return conn;
	}

	// Store user Login info in Session.
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		// On the JSP can access via ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}
	// Store user Role info in Session.
		public static void storeUserRole(HttpSession session, Role userRole) {
			session.setAttribute("userRole", userRole);
		}

	// Get the user information stored in the session.
	public static User getLoginedUser(HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
//		Role userRole = (Role) session.getAttribute("userRole");
		return loginedUser;
	}

	// Store info in Cookie
	public static void storeUserCookie(HttpServletResponse response, User user) {
		System.out.println("Store user cookie");
		Cookie cookieLogin = new Cookie(ATT_LOGIN, user.getLogin());
		// 1 day (Converted to seconds)
		cookieLogin.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieLogin);
	}

	public static String getLoginInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_LOGIN.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Delete cookie.
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieLogin = new Cookie(ATT_LOGIN, null);
		// 0 seconds (This cookie will expire immediately)
		cookieLogin.setMaxAge(0);
		response.addCookie(cookieLogin);
	}
}
