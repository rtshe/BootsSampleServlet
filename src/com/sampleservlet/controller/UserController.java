package com.sampleservlet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sampleservlet.api.domain.User;
import com.sampleservlet.apii.UserManager;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";

	private UserManager manager;

	public UserController() {
		super();
		manager = new UserManager();

	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// processRequest(request, response);

		String name = request.getParameter("txtUserName");
		String pass = request.getParameter("txtPass");

		if (name.equalsIgnoreCase("rajiv") && pass.equalsIgnoreCase("abcd"))
		// if(name.equals("prakash") && pass.equals("awatade"))

		{
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("users", manager.getAllUsers());
			rd.forward(request, response);
		} else {// if name&pass not match then it display error page//
			response.sendRedirect("error.jsp");
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// processRequest(request, response);
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			manager.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", manager.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = manager.getUserById(userId);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", manager.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;

		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// processRequest(request, response);
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));

		Date dob = new Date();
		String dateTimeStr = dob.toString();
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss zzz yyy");

		try {

			Date parseDate = format.parse(dateTimeStr);
			System.out.println(parseDate.toString());
			if (parseDate != null) {
				user.setDob(parseDate);

			}
		}

		catch (ParseException e) {
			;
		}

		user.setEmail(request.getParameter("email"));
		user.setTxtUserName(request.getParameter("txtUserName"));
		user.setTxtPass(request.getParameter("txtPass"));
		String userid = request.getParameter("userid");

		if (userid == null || userid.isEmpty()) {
			manager.addUser(user);

		} else {

			user.setUserid(Integer.parseInt(userid));
			manager.updateUser(user);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", manager.getAllUsers());

		dispatcher.forward(request, response);
	}
}
