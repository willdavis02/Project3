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
	protected int priority;
	
	public Task(String title, String description, boolean completed, LocalDate dueDate, int priority) {
		this.title= title;
		this.description= description;
		this.completed=completed;
		this.dueDate= dueDate;
		this.priority= priority;
	}
	public void markComplete() {
		completed = true;
	}
	public String toString() {
		return "Title: "+title+"| Description: "+description+"| Completed: "+completed+"| Due Date: "+dueDate+ "| Priority: "+priority+"|Task Type: "+getTaskType()+"|"+ getDetails();
	}
	public abstract String getTaskType();
	public abstract String getDetails();
	
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
