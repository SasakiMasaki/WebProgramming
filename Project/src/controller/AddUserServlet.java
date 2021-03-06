package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		User user = (User)session.getAttribute("loginUser");

		if(user == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		UserDao userDao = new UserDao();
		int result = -1;

		if(loginId.length() != 0 && name.length() != 0 && birthDate.length() != 0 && password.length() != 0 && password.equals(rePassword)) {
			result = userDao.addUser(loginId, name, birthDate, password);
		}

		if(result >= 0) {
			response.sendRedirect("UserListServlet");
			return ;
		}

		request.setAttribute("errMsg", "入力された内容が正しくありません");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
		dispatcher.forward(request, response);
	}

}
