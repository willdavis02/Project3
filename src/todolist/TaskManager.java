package todolist;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author Will Davis and Maksym Nikulin, this class has many functionalities, all relating to
 * handling the bookkeeping for the Command-Line interface. When called in the CLI, 
 * this class will be able to add tasks to a custom ArrayList from MyArrayList class, delete them,
 * mark them as complete, display them, and filter them by different qualities.
 */
public class TaskManager {
	private MyArrayList<Task> tasks = new MyArrayList<>();
	private Stack<UndoLastAction> undoStack = new Stack<>();
	private Queue<Task> todaysTasks = new LinkedList<>();
	/**
	 * !!!!!!!!Will Davis. this method simply adds an object of task to the MyArrayList tasks, and returns
	 * true once it is completed.
	 * @param task - object of task being added
	 * @return- boolean true, always. Since you can always add a new task
	 */
	public boolean addTask(Task task) {
		tasks.add(task);
		undoStack.push(new UndoLastAction("Add", task, tasks.size()-1));
		
		return true;
	}
	/**
	 * !!!!!!!!!!Author Will Davis, this takes the index of the task the user wants to remove, and
	 * simply removes the task at that index in the arrayList (MyArrayList handles edge cases)
	 * @param index- input from user, when called from commandLineInterface
	 */
	public void removeTask(int index) {
		if(index < 0 || index >= tasks.size()) {
			System.out.println("Select a valid tasks number");
			return;
		}
		
		Task removeTask = tasks.get(index);
		tasks.remove(index);
		undoStack.push(new UndoLastAction("Remove", removeTask, index));
		
	}
	

	
	/**
	 * !!!!!!!!Will Davis, this method takes in an input, and marks the completed item at that index
	 * complete. Gives error if the index isn't in the range, or if the task is completed.
	 * @param index - user input from CLI prompt
	 */
	public void markComplete(int index) {
		//Checks if the user input index is in the correct range
		if(index<0||index>= tasks.size()){
			System.out.println("Please select a valid task number");
			return;
		}
		//checks if task is marked as completed by calling isCompleted method
		if(tasks.get(index).isCompleted()) {
			System.out.println("This task has already been completed");
			return;
		}
		//If the input is fine, marks the task at that index complete. 
		else {
			tasks.get(index).markComplete();
		}
		
		tasks.get(index).markComplete();
		undoStack.push(new UndoLastAction("Complete", tasks.get(index), index));
	}
	/**
	 * Will Davis, this method called in CLI to display the tasks
	 * @return- the tasks
	 */
	public MyArrayList<Task> displayAllTasks(){
		return tasks;
	}
	/**
	 * Will Davis, this creates a new MyArrayList of Task objects, then filters 
	 * the tasks in the tasks MyArrayList by whether or not the completion status matches
	 * the wanted completion status. 
	 * @param completion- the wanted completion status of tasks
	 * @return- the tasks with the wanted completion status in a MyArrayList
	 */
	public MyArrayList<Task> filterByCompletion(boolean completion){
		MyArrayList<Task> completionstatus = new MyArrayList<>();
		//Iterate through tasks list and see if the status of each task is the desired status, add if it is
		for(Task t: tasks) {
			if(t.isCompleted()==completion) {
				completionstatus.add(t);
			}
		}
		return completionstatus;
	}
	
	/**
	 * Will Davis, this filters by the type the user wants to see. It creates a new MyArrayList,
	 * then checks the task type to see if it is equal to the wanted type.
	 * @param type -user input, desired type of task
	 * @return - MyArrayList of tasks with the desired type
	 */
	public MyArrayList<Task> filterByType(String type){
		MyArrayList<Task>typestatus= new MyArrayList<>();
		for(Task t: tasks) {
			if(t.getTaskType().equalsIgnoreCase(type)) {
				typestatus.add(t);
			}
		}
		return typestatus;
	}
	/**
	 * Will Davis, this filters by priority level by creating a new MyArrayList of tasks,
	 * and then checking if the tasks in the tasks list match desired priority, and adding
	 * them to the new list if they do
	 * @param priority -user input, desired priority level
	 * @return - list of tasks with desired priority level
	 */
	public MyArrayList<Task> filterByPriority(int priority){
		MyArrayList<Task> prioritystatus=new MyArrayList<>();
		for(Task t:tasks) {
			if(t.getPriority()==priority) {
				prioritystatus.add(t);
			}
		}
		return prioritystatus;
	}
	/** 
	 * Will Davis, getter for size so that it doesn't have to be accessed elsewhere in CLI
	 * @return
	 */
	public int getSize() {
		return tasks.size();
	}
	
	
	public void undoLastAction() {
		if(undoStack.isEmpty()) {
			System.out.println("There are no tasks do Display");
			return;
		}
		
		UndoLastAction lastAction = undoStack.pop();
		
		if(lastAction.getWhatAction().equals("Add")) {
			tasks.remove(lastAction.getTask());
			System.out.println("Added tasks was removed.");
			
		}else if(lastAction.getWhatAction().equals("Remove")) {
			tasks.add(lastAction.getTask());
			System.out.println("Removed task was added back to your list.");
			
		}else if(lastAction.getWhatAction().equals("Complete")) {
			lastAction.getTask().markIncomplete();
			System.out.println("Completed task is now marcked Incomplete");
		}
	}
	
	public void showTodayTask() {
		todaysTasks.clear();
		
		for (Task i : tasks) {
			if (i instanceof RecurringTask)
				todaysTasks.add(i);
		}
		
		System.out.println("Today's tasks are loaded into the queue");
	}
	
}
