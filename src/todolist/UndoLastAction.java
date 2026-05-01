package todolist;

public class UndoLastAction {
private String whatAction;
private Task task;
private int index;

public UndoLastAction(String whatAction, Task task, int index) {
	this.whatAction = whatAction;
	this.task = task;
	this.index = index;
}

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
