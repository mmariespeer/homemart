package edu.westga.cs6311.homemart.view;
import java.util.Scanner;
import edu.westga.cs6311.homemart.model.Inventory;
/**
 * The main user Interface that allows user to use the shopper or
 * manager side of the Homemart Application
 * @author Melissa Speer Osborne
 * @version 12/5/2016
 */
public class HomemartTUI {
	private Inventory list;
	private Scanner input;
	
	/**
	 * Create an Inventory object and a scanner object to read user input
	 * @param list is an Inventory object
	 */
	public HomemartTUI(Inventory list) {
		this.list = list;
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Director of the class, excepts user input for choice
	 */
	public void runHomemart() {
		System.out.println("Welcome to the Homemart Application");
		int answer = 0;
		do {
			this.displayMenu();
			String selection = this.input.nextLine();
			answer = Integer.parseInt(selection);
			
			if (answer <= 0 || answer > 3) {
				System.out.println("Invalid Choice");
			} else if (answer == 1) {
				this.openManager();
			} else if (answer == 2) {
				this.openShopper();
			} else {
				return;
			}
			
		} while (answer != 3);
		
		System.out.println("Thank you for using the Homemart application. Have a lovely day!");
		
		
	}
	
	private void displayMenu() {
		System.out.print("\n\t1 - Start Manager Application\n\t2 - Start Shopper Application\n\t3 - Quit\n\tEnter your choice: \n");
	}
	
	private void openManager() {
		ManagerTUI tuiManagerSide = new ManagerTUI(this.list);
		tuiManagerSide.runManager();
	}
	
	private void openShopper() {
		ShopperTUI tuiShopperSide = new ShopperTUI(this.list);
		tuiShopperSide.runShopper();
	}
}
