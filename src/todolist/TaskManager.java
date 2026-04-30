package todolist;

public class TaskManager {
	MyArrayList<Task> tasks = new MyArrayList<>();
	
	public boolean addTask(Task task) {
		tasks.add(task);
		return true;
	}
	public void removeTask(Task task) {
		tasks.remove(task);
	}
}
