package todo.model;

import java.util.Date;

public class Todo {

	/**
	 * ID
	 */
	private int id;

	/**
	 * 内容
	 */
	private String task;
	/**
	 * 期限
	 */
	private Date limit;
	/**
	 * 完了フラグ
	 */
	private boolean done;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getLimit() {
		return limit;
	}
	public void setLimit(Date limit) {
		this.limit = limit;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
}
