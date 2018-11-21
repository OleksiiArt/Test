package ua.nure.artemenko.SummaryTask4.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.artemenko.SummaryTask4.db.LoginDAO;
import ua.nure.artemenko.SummaryTask4.db.entity.LoginBean;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3807863268392590530L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward to /WEB-INF/views/loginView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String login = request.getParameter("login");
		 String password = request.getParameter("password");
		 
		 LoginBean loginBean = new LoginBean();
		 
		 loginBean.setLogin(login);
		 loginBean.setPassword(password);
		 LoginDAO loginDao = new LoginDAO();
		 
		 try
		 {
		 String userValidate = loginDao.authenticateUser(loginBean);
		 
		 if(userValidate.equals("administrator_Role"))
		 {
		 System.out.println("Admin's Home");
		 
		 HttpSession session = request.getSession(); //Creating a session
		 session.setAttribute("1", login); //setting session attribute
		 request.setAttribute("login", login);
		 
		 
		 
		 request.getRequestDispatcher("/WEB-INF/views/admin/userInfoAdmin.jsp").forward(request, response);
		 }
		 else if(userValidate.equals("dispatcher_Role"))
		 {
		 System.out.println("Editor's Home");
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("2", login);
		 request.setAttribute("login", login);
		 
		 request.getRequestDispatcher("/WEB-INF/views/dispatcher/userInfoDispatcher.jsp").forward(request, response);
		 }
//		 else if(userValidate.equals("User_Role"))
//		 {
//		 System.out.println("User's Home");
//		 
//		 HttpSession session = request.getSession();
//		 session.setMaxInactiveInterval(10*60);
//		 session.setAttribute("User", login);
//		 request.setAttribute("userName", userName);
//		 
//		 request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
//		 }
		 else
		 {
			 
		 System.out.println("Error message = "+userValidate);
		 request.setAttribute("errMessage", userValidate);
		 
		 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		 }
		 }
		 catch (IOException e1)
		 {
		 e1.printStackTrace();
		 }
		 catch (Exception e2)
		 {
		 e2.printStackTrace();
		 }
		} 

		
		
		
		
/*		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		User user = null;
		boolean hasError = false;
		String errorString = null;

		String administrator = null;
		String dispatcherRole = null;

		if (login == null || password == null || login.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			Connection con = MyUtils.getStoredConnection(request);
			try {
				// Find the user in the DB.
				user = DBManager.getInstance().findUserByLogin(con, login);

				if (user == null || !password.equals(user.getPassword())) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (Exception e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
// 
			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");

			dispatcher.forward(request, response);
		}
		// If no error
		// Store user information in Session
		// And redirect to userInfo page.

		else {
			Role userRole = Role.getRole(user);
			HttpSession session = request.getSession();
			MyUtils.storeUser(session, user);
//			MyUtils.storeUserRole(session, userRole);
			System.out.println("My Util store");
			

			// If user checked "Remember me".
			if (remember) {
				MyUtils.storeUserCookie(response, user);
			}
			// Else delete cookie.
			else {
				MyUtils.deleteUserCookie(response);
			}
			System.out.println("So close");

			  if (userRole == Role.ADMINISTRATOR) {
//				 session.setAttribute("userRole", administrator);
				response.sendRedirect(request.getContextPath() + "/userInfoAdmin");
			} else if (userRole == Role.DISPATCHER) {
//				 session.setAttribute("userRole", dispatcherRole);
				response.sendRedirect(request.getContextPath() + "/userInfoDispatcher");
			}
			

		}
		*/
	}
	


