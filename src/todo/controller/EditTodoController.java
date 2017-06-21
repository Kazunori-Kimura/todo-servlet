package todo.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.IllegalActionException;
import todo.NotFoundException;
import todo.dao.TodoDAO;
import todo.model.Todo;
import todo.util.ConvertHelper;

/**
 * Servlet implementation class EditTodoController
 */
@WebServlet("/Edit")
public class EditTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDAO dao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTodoController() {
        super();

        this.dao = new TodoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// QueryStringからactionを取得
		String action = request.getParameter("action");
		// actionを保持
		request.setAttribute("action", action);

		try {
			if ("create".equals(action)) {

				this.doGetCreate(request, response);

			} else if ("update".equals(action) || "delete".equals(action)) {

				this.doGetUpdateOrDelete(request, response);

			} else {

				// actionの指定に問題アリ
				throw new IllegalActionException();

			}

			// edit.jspを表示
			request.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(request, response);

		} catch (NumberFormatException | NotFoundException | IllegalActionException e) {
			e.printStackTrace();
			// 例外が発生したらリストに戻す
			response.sendRedirect("List");
		}
	}

	/**
	 * Todo追加画面の表示
	 *
	 * @param request
	 * @param response
	 */
	private void doGetCreate(HttpServletRequest request, HttpServletResponse response) {
		// 空のTodo
		Todo todo = new Todo();
		request.setAttribute("todo", todo);
	}

	/**
	 * Todo更新画面の表示
	 *
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws NotFoundException
	 */
	private void doGetUpdateOrDelete(HttpServletRequest request, HttpServletResponse response)
		throws NumberFormatException, NotFoundException {

		// idを取得
		int id = Integer.parseInt(request.getParameter("id"));
		// Todoを検索
		Todo todo = this.dao.findById(id);
		request.setAttribute("todo", todo);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// フォームからTodoを取得
			Todo todo = getTodo(request);

			String action = request.getParameter("action");

			if ("create".equals(action)) {

				this.dao.add(todo);

			} else if ("update".equals(action)) {

				this.dao.update(todo);

			} else if ("delete".equals(action)) {

				this.dao.delete(todo.getId());

			} else {

				// actionの指定に問題あり
				throw new IllegalActionException();
			}

			// 処理完了時はリストに戻す
			response.sendRedirect("List");

		} catch (NumberFormatException | ParseException | IllegalActionException | NotFoundException e) {
			e.printStackTrace();
			// エラーメッセージ表示
			request.setAttribute("message", "例外が発生しました。");
			// Getに戻す
			doGet(request, response);
		}
	}

	/**
	 * formからpostされてきた内容を取得
	 *
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	private Todo getTodo(HttpServletRequest request) throws NumberFormatException, ParseException {
		Todo todo = new Todo();

		// id
		String rawId = request.getParameter("id");
		int id = Integer.parseInt(rawId);
		todo.setId(id);

		// task
		String task = request.getParameter("task");
		todo.setTask(task);

		// limit
		String rawLimit = request.getParameter("limit");
		todo.setLimit(ConvertHelper.parseDate(rawLimit));

		// done
		String rawDone = request.getParameter("done");
		todo.setDone(this.isChecked(rawDone));

		return todo;
	}

	/**
	 * チェックされているかどうかの判定
	 *
	 * @param raw
	 * @return
	 */
	private boolean isChecked(String raw) {
		return "on".equals(raw);
	}

}
