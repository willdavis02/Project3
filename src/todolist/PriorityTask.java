package todolist;

import java.time.LocalDate;

/**
 * Author Will Davis, this class is the child of the Task class and implements the
 * Prioritizable interface. It's utilized when the priority level of the task needs to
 * have the ability to be updated. It allows for the updating of priority level, as well
 * as has its own implementations of the abstract methods from the Task class.
 */
public class PriorityTask extends Task implements Prioritizable {
	
	public PriorityTask(String title, String description, boolean completed, LocalDate dueDate, int priority) {
		super(title, description, completed, dueDate, priority);
	}
	public void setPriority(int priority) {
		this.priority= priority;
	}

	public String getTaskType() {
		return "Priority";
	}
	public String getDetails() {
		return "Priority Type: "+getPriority();
	}


}
