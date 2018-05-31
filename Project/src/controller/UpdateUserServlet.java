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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session =  request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		User user = null;
		UserDao userDao = new UserDao();

		if(loginUser == null) {
			response.sendRedirect("LoginServlet");
			return;
		}
		user = userDao.findListByLoginId(request.getParameter("loginId"));
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		int result = -1;

		if(name.length() != 0 && birthDate.length() != 0) {
			if(password.equals(rePassword) && password.length() != 0) {
				//パスワード以外の更新メソッド
			}else {
				result = -1;
			}
		}

		if(result < 0) {
			request.setAttribute("user", request.getAttribute("user"));
			request.setAttribute("errMsg", "入力された内容が正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp");
			dispatcher.forward(request, response);
		}
	}

}
