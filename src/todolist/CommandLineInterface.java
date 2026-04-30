package todolist;
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
	public void start() {
		System.out.println("Enter your name:");
		String name= scn.nextLine();
		System.out.println("Welcome to the To-Do List Manager, "+name+"!");
		System.out.println("To begin, enter a number to select the task");
		System.out.println("");
		printMenu();
		
		int choice = scn.nextInt();
		while(choice!=10) {
			switch(choice) {
				case 1:
					
					break;
				
				case 2:
					
					break;
				
				case 3:
					
					break;
				case 4:
					
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
			choice=scn.nextInt();
		}
		System.out.println("Thank you for using To-Do List Manager, Goodbye, "+name+"!");
		scn.close();
	}
}
