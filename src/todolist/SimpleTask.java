package todolist;

import java.time.LocalDate;

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
