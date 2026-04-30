package todolist;
/**
 * Author Will Davis, this class has many functionalities, all relating to
 * handling the bookkeeping for the Command-Line interface. When called in the CLI, 
 * this class will be able to add tasks to a custom ArrayList from MyArrayList class, delete them,
 * mark them as complete, display them, and filter them by different qualities.
 */
public class TaskManager {
	MyArrayList<Task> tasks = new MyArrayList<>();
	
	public boolean addTask(Task task) {
		tasks.add(task);
		return true;
	}
	public void removeTask(Task task) {
		tasks.remove(task);
	}
	public void markComplete(int index) {
		if(index<0||index>= tasks.size()){
			System.out.println("Please select a valid task number");
			return;
		}
		if(tasks.get(index).isCompleted()) {
			System.out.println("This task has already been completed");
			return;
		}
		else {
			tasks.get(index).markComplete();
		}
	}
	public MyArrayList<Task> displayAllTasks(){
		return tasks;
	}
	public MyArrayList<Task> filterByCompletion(boolean completion){
		MyArrayList<Task> completionstatus = new MyArrayList<>();
		for(Task t: tasks) {
			if(t.isCompleted()==completion) {
				completionstatus.add(t);
			}
		}
		return completionstatus;
	}
	public MyArrayList<Task> filterByType(String type){
		MyArrayList<Task>typestatus= new MyArrayList<>();
		for(Task t: tasks) {
			if(t.getTaskType().equalsIgnoreCase(type)) {
				typestatus.add(t);
			}
		}
		return typestatus;
	}
	public MyArrayList<Task> filterByPriority(int priority){
		MyArrayList<Task> prioritystatus=new MyArrayList<>();
		for(Task t:tasks) {
			if(t.getPriority()==priority) {
				prioritystatus.add(t);
			}
		}
		return prioritystatus;
	}
	
}
