package todolist;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Authors Will Davis and Maksym Nikulin, this class builds the whole
 * CLI that the user will interact with. This includes displaying the menu,
 * taking in user input, and from there calling the correct methods from
 * TaskManager class. 
 */
public class CommandLineInterface {
	Scanner scn= new Scanner(System.in);
	TaskManager tm = new TaskManager();
	
	/**
	 * Will Davis, separate printMenu method to avoid repeated code. Method is called 
	 * at the end of actions. Lists all possible menu actions a user can take
	 */
	public void printMenu() {
		System.out.println("1. Add Task");
		System.out.println("2. View All Tasks");
		System.out.println("3. Complete Task");
		System.out.println("4. Remove Task");
		System.out.println("5. Undo Last Action");
		System.out.println("6. Load Today's Tasks");
		System.out.println("7. View Task Queue");
		System.out.println("8. Process Next Task");
		System.out.println("9. Filter Tasks");
		System.out.println("10. Exit");
	}
	
	/**
	 * Will Davis, this is for input validation purposes. for simplicity sake all options are listed
	 * to user on most actions with numbered formats, so this method checks to ensure that the
	 * input from the user is an integer, and falls within the range of the number of options
	 * @param min-lowest option user can choose
	 * @param max-highest option user can choose
	 * @return- the input, so long as it's valid
	 */
	public int getValidInt(int min, int max) {
		int input=0;
		while(true) {
			if(scn.hasNextInt()) {
				input= scn.nextInt();
				if(input >= min && input <= max) {
					break;
				} else {
					System.out.println("Enter a valid integer between "+min+  " and "+max+": ");
				}
			} else {
				scn.next();
				System.out.println("Please enter an integer input: ");
			}
		}
		//eats blank line
		scn.nextLine();
		return input;	
	}
	
	/**
	 * Will Davis (1,2,3,4) Maksym Nikulin(5,6,7,8,9). This runs the whole CLI, from printing a welcome message
	 * to accepting input for actions the user can take. A while loop is used to ensure that until the user enters 
	 * the exit command, the loop remains running. All logic and input validation for the actions in printMenu method
	 * are handled here.
	 */
	public void start() {
		//starting welcome message
		System.out.println("Enter your name:");
		String name= scn.nextLine();
		System.out.println("Welcome to the To-Do List Manager, "+name+"!");
		printMenu();
		System.out.println("To begin, enter a number to select the task");
		int choice = getValidInt(1,10);
		//enters menu choice action based on user choice
		while(choice!=10) {
			switch(choice) {
				//Add item
				case 1:
					System.out.println("You have chosen to add a task. What kind of task would you like to add?");
					System.out.println("1. Simple Task (Doesn't repeat)");
					System.out.println("2. Priority Task (modifiable priority)");
					System.out.println("3. Recurring Task (repeating task");
					System.out.println("Choose the corresponding number: ");
					//gets user input for type of task
					int tasktype = getValidInt(1,3);
					String recurrence= "";
					int recur= 0;
					//additional prompts for recurring task additional info
					if(tasktype==3) {
						System.out.println("You have chose recurring task, how often will it occur?");
						System.out.println("1. Daily");
						System.out.println("2. Weekly");
						System.out.println("3. Monthly");
						System.out.println("Choose the corresponding number: ");
						recur = getValidInt(1,3);
						//Correct recurring type based on user input
						if(recur==1) {
							recurrence= "DAILY";
						}
						if(recur==2) {
							recurrence="WEEKLY";
						}
						if(recur==3) {
							recurrence="MONTHLY";
						}
					}
					//Get the rest of the parameters to create a Task object(or rather, a child object)
					System.out.println("Task name: ");
					String title= scn.nextLine();
					System.out.println("Brief description of task: ");
					String description= scn.nextLine();
					boolean completed= false;
					//input validation for localdate (found on stackOverflow)
					LocalDate date= null;
					while(date==null) {
						System.out.println("Enter the date this task must be completed by(YYYY-MM-DD)");
						String dateinput=scn.nextLine();
						try {
							date= LocalDate.parse(dateinput);
						}
						catch(Exception e){
							System.out.println("Enter the date in the provided format");
						}
					}
					System.out.println("Enter a level of priority 1-5: ");
					int priority=getValidInt(1,5);
					//create the correct task type with all collected info, based on the tasktype prompt.
					if(tasktype==1) {
						SimpleTask st = new SimpleTask(title,description,completed,date,priority);
						tm.addTask(st);
					}
					if(tasktype==2) {
						PriorityTask pt= new PriorityTask(title, description,completed,date,priority);
						tm.addTask(pt);
					}
					if(tasktype== 3) {
						RecurringTask rt= new RecurringTask(title, description, completed, date, priority, recurrence);
						tm.addTask(rt);
					}
					System.out.println("Task successfully added!");
					
					break;
					
				//List the tasks
				case 2:
					if(tm.getSize()==0) {
						System.out.println("There are no tasks in your To-Do list");
						break;
					}
					//Creates a new MyArrayList so that it can print one by one for readability
					MyArrayList<Task> tasks =tm.displayAllTasks();
					System.out.println("===Task View===");
					for(Task t: tasks) {
						System.out.println(t);
					}
					break;
					
				//mark complete
				case 3:
					if(tm.getSize()==0) {
						System.out.println("There are no tasks in your To-Do list");
						break;
					}
					//Same idea as List tasks action, but just simpler with titles only
					MyArrayList<Task> tasks1= tm.displayAllTasks();
					int index=1;
					for(Task t: tasks1) {
						System.out.println(index+ ". "+t.getTitle());
						index++;
					}
					System.out.println("Enter the number of the task you'd like to mark complete: ");
					int complete= getValidInt(1, tm.getSize());
					// -1 for index purposes
					tm.markComplete(complete-1);
					break;
					
				//Delete task	
				case 4:
					if(tm.getSize()==0) {
						System.out.println("There are no tasks in your To-Do list");
						break;
					}
					//Same idea, list the task names
					MyArrayList<Task> task2= tm.displayAllTasks();
					int i=1;
					for(Task t: task2) {
						System.out.println(i+ ". "+t.getTitle());
						i++;
					}
					System.out.println("Enter the number of the task you want to remove: ");
					int delete= getValidInt(1, tm.getSize());
					tm.removeTask(delete-1);
					break;
					
					
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				

			}
			printMenu();
			choice=getValidInt(1,10);
		}
		System.out.println("Thank you for using To-Do List Manager, Goodbye, "+name+"!");
		scn.close();
	}
}
