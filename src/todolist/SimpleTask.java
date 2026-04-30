package todolist;

import java.time.LocalDate;
/**
 * Author Will Davis, this class is used to create a task of the simplest form, hence the name.
 * The only difference between this and the parent class Task is that it implements the abstract
 * methods. No updating priority necessary, and it is not a recurring task.
 */
public class SimpleTask extends Task{
	
	public SimpleTask (String title, String description, boolean completed, LocalDate dueDate, int priority) {
		super(title, description, completed, dueDate, priority);
	}
	
	public String getTaskType() {
		return "Simple";
	}
	public String getDetails() {
		return "";
	}
}
