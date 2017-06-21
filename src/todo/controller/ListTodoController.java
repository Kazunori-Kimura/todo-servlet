package todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
import todo.model.Todo;

/**
 * Servlet implementation class ListTodoController
 */
@WebServlet("/List")
public class ListTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDAO dao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTodoController() {
        super();

        this.dao = new TodoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// daoからリストを取得
		List<Todo> list = this.dao.getAll();

		// requestにTodoリストを保持
		request.setAttribute("list", list);

		// list.jspにforward
		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
