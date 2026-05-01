package todolist;

import java.time.LocalDate;
/**
 * Author Will Davis, this class is used to create a task of the simplest form, hence the name.
 * The only difference between this and the parent class Task is that it implements the abstract
 * methods. No updating priority necessary, and it is not a recurring task.
 */
public class SimpleTask extends Task{
	
	/**
	 * Constructor with no specific parameters to the class, so just calls the Task(parent) constructor
	 * @param title
	 * @param description
	 * @param completed
	 * @param dueDate
	 * @param priority
	 */
	public SimpleTask (String title, String description, boolean completed, LocalDate dueDate, int priority) {
		super(title, description, completed, dueDate, priority);
	}
	/**
	 * Abstract from Task, returns type of task, in this case Simple
	 */
	@Override
	public String getTaskType() {
		return "Simple";
	}
	/**
	 * Abstract from Task, returns additional information unique to tasktype,
	 * in this case there is nothing
	 */
	@Override
	public String getDetails() {
		return "";
	}
}
