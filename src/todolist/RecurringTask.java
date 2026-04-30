package todolist;

import java.time.LocalDate;

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
