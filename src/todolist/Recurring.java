package todolist;
/**
 * Author Will Davis, this interface lists what needs to be implemented
 * for a class to be able to create recurring tasks. This is done by setting
 * the pattern of recurring tasks, as well as being able to retrieve them.
 */
public interface Recurring {
	void setRecurrencePattern(String pattern);
	String getRecurrencePattern();
}
