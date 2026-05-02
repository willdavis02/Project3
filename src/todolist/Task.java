package todolist;

import java.time.LocalDate;

/**
 * Author Will Davis, this is an abstract class that has attributes for 
 * an object of Task, such as title, description, completed, dueDate, and
 * priority. The constructor creates an object of task, and it provides
 * abstract methods for the children classes to implement
 */
public abstract class Task {
	private String title;
	private String description;
	private boolean completed;
	private LocalDate dueDate;
	//protected because setter is created in PriorityTask, since that is the only one that should be able to change priority
	protected int priority;
	
	/**
	 * Constructor, takes in all the attributes needed to make an object of task (although task is an abstract class, so an object can't be created,
	 * only the child classes can. They will call this constructor).
	 * @param title - name of task
	 * @param description - explanation of task
	 * @param completed - whether task is complete or not.
	 * @param dueDate - LocalDate of when the task needs to be completed
	 * @param priority- level of need to complete
	 */
	public Task(String title, String description, boolean completed, LocalDate dueDate, int priority) {
		this.title= title;
		this.description= description;
		this.completed=completed;
		this.dueDate= dueDate;
		this.priority= priority;
	}
	/**
	 * Marks a task as complete.
	 */
	public void markComplete() {
		completed = true;
	}
	/**
	 * Format for the way task information is printed. Additional details are called from getDetails method
	 */
	public String toString() {
		return "Title: "+title+"| Description: "+description+"| Completed: "+completed+"| Due Date: "+dueDate+ "| Priority: "+priority+"|Task Type: "+getTaskType()+"|"+ getDetails();
	}
	
	/**
	 * Marks a task as incomplete
	 */
	public void markIncomplete() {
		completed = false;
	}
	/**
	 * Abstract methods that are defined in each class. Provide type of task, and any additional
	 * information unique to that task type.
	 * @return
	 */
	public abstract String getTaskType();
	public abstract String getDetails();
	
	
	/**
	 * Getters for all classes
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	public boolean isCompleted() {
		return completed;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public int getPriority() {
		return priority;
	}


}
