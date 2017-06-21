package todo.dao;

import java.util.List;
import java.util.ListIterator;

import todo.NotFoundException;
import todo.model.Todo;
import todo.service.TodoService;

public class TodoDAO {

	private TodoService service = TodoService.getInstance();

	/**
	 * Todoを追加する
	 *
	 * @param todo
	 * @return 採番したIDを返す
	 */
	public int add(Todo todo) {
		// IDを採番
		int id = this.service.nextValue();
		// IDをセット
		todo.setId(id);
		// Todoをリストにセット
		this.service.getTodos().add(todo);

		return id;
	}

	/**
	 * idを指定してTodoを削除する
	 *
	 * @param id
	 * @throws NotFoundException
	 */
	public void delete(int id) throws NotFoundException {
		// Todoリスト
		List<Todo> list = this.service.getTodos();

		// Java8 の List#removeIf を使った場合
		boolean deleted = list.removeIf((todo) -> {
			return id == todo.getId();
		});

		if (!deleted) {
			// 1件も削除されなかった
			// -> 該当Todoが見つからなかった
			throw new NotFoundException();
		}
	}

	/**
	 * Todoを更新する
	 *
	 * @param todo
	 * @throws NotFoundException
	 */
	public void update(Todo todo) throws NotFoundException {
		// 該当のTodoが存在する？
		boolean exists = false;
		// Todoリスト
		List<Todo> list = this.service.getTodos();

		// listIteratorを使うと要素の置換が簡単
		ListIterator<Todo> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Todo item = iterator.next();
			if (item.getId() == todo.getId()) {
				exists = true;
				// IDが一致する項目を置換
				iterator.set(todo);
				// 置換したらループ終了
				break;
			}
		}

		if (!exists) {
			// 該当のTodoがない
			throw new NotFoundException();
		}
	}

	/**
	 * 全件取得
	 *
	 * @return
	 */
	public List<Todo> getAll() {
		return this.service.getTodos();
	}

	/**
	 * IDを指定してTodoを取得
	 *
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public Todo findById(int id) throws NotFoundException {
		List<Todo> list = this.service.getTodos();

		// 拡張for文
		for (Todo todo : list) {
			if (id == todo.getId()) {
				return todo;
			}
		}

		// 該当Todoがなければ例外
		throw new NotFoundException();
	}

}
