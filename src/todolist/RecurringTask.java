package todolist;

import java.time.LocalDate;
/**
 * Author Will Davis, this class is used to create tasks that are recurring.
 *  this class is the child of the Task class and implements
 * the Recurring interface. It has it's own attribute recurrencePattern, which is 
 * added to the constructor, as well as used to have getter and setters for that
 * attribute. It also uses its own implementations of the abstract methods in
 * Task class. 
 */
public class RecurringTask extends Task implements Recurring {
	private String recurrencePattern;
	
	
	public RecurringTask(String title, String description, boolean completed, LocalDate dueDate, int priority, String recurrencePattern) {
		super(title, description,completed, dueDate, priority);
		this.recurrencePattern = recurrencePattern;
	}
	
	public void setRecurrencePattern(String pattern) {
		this.recurrencePattern= pattern;
	}
	public String getRecurrencePattern() {
		return recurrencePattern;
	}
	
	
	public String getTaskType() {
		return "Recurring";
	}
	public String getDetails() {
		return " Recurrence Pattern: "+ recurrencePattern;
	}


}
