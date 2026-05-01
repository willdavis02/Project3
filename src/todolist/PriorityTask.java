package todolist;

import java.time.LocalDate;

/**
 * Author Will Davis, this class is the child of the Task class and implements the
 * Prioritizable interface. It's utilized when the priority level of the task needs to
 * have the ability to be updated. It allows for the updating of priority level, as well
 * as has its own implementations of the abstract methods from the Task class.
 */
public class PriorityTask extends Task implements Prioritizable {
	
	/**
	 * Constructor, doesn't require passing any more parameters, no unique attributes in this
	 * class, so it just calls the constructor from parent class
	 * @param title
	 * @param description
	 * @param completed
	 * @param dueDate
	 * @param priority
	 */
	public PriorityTask(String title, String description, boolean completed, LocalDate dueDate, int priority) {
		super(title, description, completed, dueDate, priority);
	}
	/**
	 * From interface Prioritizable, simply allows for modifying priority level
	 */
	public void setPriority(int priority) {
		this.priority= priority;
	}
	/**
	 * Abstract method from Task, returns type of task, in this case it is a Priority Task
	 */
	@Override
	public String getTaskType() {
		return "Priority";
	}
	/**
	 * Abstract method from Task, returns additional information, in this case
	 * the Priority level
	 */
	@Override
	public String getDetails() {
		return "Priority Level: "+getPriority();
	}


}
