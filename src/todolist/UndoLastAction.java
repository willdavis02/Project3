package todolist;


/**
 * Author Maksym Nikulin. This class is used to perform undo Last action function. 
 * It stores what task it is, and what action was performed on that task.
 */
public class UndoLastAction {
private String whatAction;
private Task task;
private int index;

/**
 * @param whatAction - Last Performed action on the task
 * @param task - What Task was action performed on
 * @param index - Index of the task, so we know where it was if need to put it back
 */
public UndoLastAction(String whatAction, Task task, int index) {
	this.whatAction = whatAction;
	this.task = task;
	this.index = index;
}

//Getters:

public String getWhatAction() {
	return whatAction;
}

public Task getTask() {
	return task;
}

public int getIndex() {
	return index;
}
}
