package edu.westga.cs6311.homemart.view;
import edu.westga.cs6311.homemart.model.Inventory;
import java.util.Scanner;
/**
 * The Manager side User Interface of the application
 * @author Melissa Speer Osborne
 * @version 12/4/2016
 */
public class ManagerTUI {
	private Inventory list;
	private Scanner input;
	
	/**
	 * Create a new list and a scanner object for collecting user input
	 * @param list and Inventory object
	 */
	public ManagerTUI(Inventory list) {
		this.list = new Inventory();
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Directions to run the Manager application, read user input and call
	 * required methods
	 */
	public void runManager() {
		System.out.println("Welcome to the Manager Application");
		int answer = 0;
		do {
			this.displayMenu();
			String selection = this.input.nextLine();
			answer = Integer.parseInt(selection);
			
			if (answer <= 0 || answer > 4) {
				System.out.println("Invalid Choice");
			} else if (answer == 1) {
				this.openStore();
			} else if (answer == 2) {
				this.addNewItem();
			} else if (answer == 3) {
				this.printInventoryReport();
			} else {
				return;
			}
			
		} while (answer != 4);
		
		System.out.println("Thank you for using the manager application");
		
	}
	
	
	
	private void displayMenu() {
		System.out.print("\n\t1 - Open new Store\n\t2 - Add new item\n\t3 - View inventory\n\t4 - Quit Manager Application\n\n\tEnter your choice: \n");
	}
	
	private void openStore() {
		this.list.openStore();
	}
	
	private void addNewItem() {
		String name;
		double cost;
		int qty;
		System.out.println("Please enter the item's name: ");
		name = this.input.nextLine();
		do {
			System.out.println("Please enter the item's cost: ");
			String dollarAmount = this.input.nextLine();
			cost = Double.parseDouble(dollarAmount);
		} while (cost <= 0 || cost > 999.99);
		
		do {
			System.out.println("Please enter the item's quantity: ");
			String number = this.input.nextLine();
			qty = Integer.parseInt(number);	
		} while (qty <= 0 || qty > 999);	
		this.list.addItem(name, cost, qty);
		System.out.println("You have added " + qty + " " + name + "(s) to the inventory.\n");
	}
	
	private void printInventoryReport() {
		System.out.print(this.list.toString());
	}
}
