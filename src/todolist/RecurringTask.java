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
	//specific attribute to this class, how often event repeats
	private String recurrencePattern;
	
	/**
	 * Constructor, calls parent constructor for everything except recurrencePattern, since that is
	 * unique to this class
	 * @param title
	 * @param description
	 * @param completed
	 * @param dueDate
	 * @param priority
	 * @param recurrencePattern
	 */
	public RecurringTask(String title, String description, boolean completed, LocalDate dueDate, int priority, String recurrencePattern) {
		super(title, description,completed, dueDate, priority);
		this.recurrencePattern = recurrencePattern;
	}
	
	/**
	 * From interface Recurring, getters and setters for the recurrencePattern
	 */
	public void setRecurrencePattern(String pattern) {
		this.recurrencePattern= pattern;
	}
	public String getRecurrencePattern() {
		return recurrencePattern;
	}
	
	/**
	 * Abstract method from Task, returns type of task, in this case a recurring task
	 */
	@Override
	public String getTaskType() {
		return "Recurring";
	}
	/**
	 * Abstract method from Task, returns additional information unique to this task type.
	 */
	@Override
	public String getDetails() {
		return " Recurrence Pattern: "+ recurrencePattern;
	}


}