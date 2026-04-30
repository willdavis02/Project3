package todolist;

import java.time.LocalDate;

public class PriorityTask extends Task implements Prioritizable {
	
	public PriorityTask(String title, String description, boolean completed, LocalDate dueDate, int priority) {
		super(title, description, completed, dueDate, priority);
	}
	public void setPriority(int priority) {
		this.priority= priority;
	}

	public String getTaskType() {
		return "High Priority";
	}
	public String getDetails() {
		return "";
	}


}
