package todo.service;

import java.util.ArrayList;
import java.util.List;

import todo.model.Todo;

/**
 * シングルトンなTodoリスト管理クラス
 *
 * @author kimurakazunori
 *
 */
public class TodoService {

	private static TodoService instance = new TodoService();

	/**
	 * Todoのリスト
	 */
	private List<Todo> todos = new ArrayList<Todo>();

	/**
	 * シーケンス番号
	 */
	private int sequence = 0;

	/**
	 * private にしたコンストラクタ
	 */
	private TodoService() {

	}

	/**
	 * インスタンスを取得する
	 *
	 * @return
	 */
	public static TodoService getInstance() {
		return instance;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public int currentValue() {
		return this.sequence;
	}

	public int nextValue() {
		this.sequence++;
		return this.sequence;
	}

}
