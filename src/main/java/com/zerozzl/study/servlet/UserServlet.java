package com.zerozzl.study.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerozzl.study.common.dao.impl.UserDaoImpl;
import com.zerozzl.study.common.model.UserDO;
import com.zerozzl.study.lang.db.JdbcUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JdbcUtils.init();
		String action = request.getParameter("action");
		if (action.equals("list")) {
			List<UserDO> users = null;
			try {
				users = this.findUsers();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("users", users);
			request.getRequestDispatcher("user/user_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<UserDO> findUsers() throws SQLException {
		UserDaoImpl dao = new UserDaoImpl();
		return dao.selectAll();
	}

}
