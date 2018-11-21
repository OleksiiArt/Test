package ua.nure.artemenko.SummaryTask4.filters;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.nure.artemenko.SummaryTask4.MyUtils;
import ua.nure.artemenko.SummaryTask4.db.DBManager;
import ua.nure.artemenko.SummaryTask4.db.entity.User;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter  implements Filter{
	
	 public CookieFilter() {
	    }
	 
	    @Override
	    public void init(FilterConfig fConfig) throws ServletException {
	 
	    }
	 
	    @Override
	    public void destroy() {
	 
	    }
	 
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpSession session = req.getSession();
	 
	        User userInSession = MyUtils.getLoginedUser(session);
	        // 
	        if (userInSession != null) {
	            session.setAttribute("COOKIE_CHECKED", "CHECKED");
	            chain.doFilter(request, response);
	            return;
	        }
	 
	        // Connection was created in JDBCFilter.
	        Connection con = MyUtils.getStoredConnection(request);
	 
	        // Flag check cookie
//	        Role userRole = null;
	        String checked = (String) session.getAttribute("COOKIE_CHECKED");
	        if (checked == null && con != null) {
	            String login = MyUtils.getLoginInCookie(req);
	            try {
	                User user = DBManager.getInstance().findUserByLogin(con, login);
	                MyUtils.storeLoginedUser(session, user);
//	                MyUtils.storeUserRole(session, userRole);
	            } catch ( Exception e) {
	                e.printStackTrace();
	            }
	            // Mark checked Cookies.
	            session.setAttribute("COOKIE_CHECKED", "CHECKED");
	        }
	 
	        chain.doFilter(request, response);
	    }

}
