package todolist;
/**
 * Author Will Davis, this interface simply lists the requirements
 * needed if a class wants to be prioritizable, aka able to update
 * the priority level.
 */
public interface Prioritizable {
	void setPriority(int priority);
	int getPriority();
}
