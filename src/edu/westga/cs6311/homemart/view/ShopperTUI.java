package edu.westga.cs6311.homemart.view;
import java.util.Scanner;
import edu.westga.cs6311.homemart.model.Shopper;
import edu.westga.cs6311.homemart.model.Inventory;
import edu.westga.cs6311.homemart.model.InventoryItem;
/**
 * This class serves as the shopper-side director of the application
 * @author Melissa Speer Osborne
 * @version 12/5/2016
 */
public class ShopperTUI {
	private Inventory list;
	private Shopper theShopper;
	private Scanner input;
	
	/**
	 * Creates an inventory object, a shopper object, and a scanner object for user input
	 * @param list the inventory object
	 */
	public ShopperTUI(Inventory list) {
		this.list = list;
		this.input = new Scanner(System.in);
		String name = "";
		double dollarAmount = 0;
		Shopper theShopper = new Shopper(name, dollarAmount);
		
	}
	/**
	 * Directions to run application and call methods based on user input
	 */
	public void runShopper() {
		System.out.println("Welcome to the Shopper Application");
		this.getShopperInformation();
		int answer = 0;
		do {
			this.displayMenu();
			String selection = this.input.nextLine();
			answer = Integer.parseInt(selection);
			
			if (answer <= 0 || answer > 6) {
				System.out.println("Invalid Choice");
			} else if (answer == 1) {
				this.printInventoryReport();
			} else if (answer == 2) {
				this.addItemToCart();
			} else if (answer == 3) {
				this.viewCart();
			} else if (answer == 4) {
				this.viewMoney();
			} else if (answer == 5) {
				this.checkout();
			} else {
				return;
			}
			
		} while (answer != 6);
		
		System.out.println("Thank you for using the shopper application");
		
	}
	private void getShopperInformation() {
		System.out.println("Please enter your name: ");
		String name = this.input.nextLine();
		System.out.println("Please enter the amount you have to spend: ");
		String amount = this.input.nextLine();
		double dollarAmount = Double.parseDouble(amount);
		System.out.println("Welcome " + name + ". Enjoy spending your $" + dollarAmount);
	}
	
	private void displayMenu() {
		System.out.print("\n\t1 - View inventory\n\t2 - Add item to the cart\n\t3 - View cart\n\t4 - View money "
				+ "remaining\n\t5 - Checkout\n\t6 - Quit Shopper Application\n\tEnter your choice: \n");
	}
	
	private void printInventoryReport() {
		System.out.print(this.list.toString());
	}
	
	private void addItemToCart() {
		System.out.println("Enter the item to be purchased: ");
		String answer = this.input.nextLine();
		InventoryItem theItem = this.list.findItem(answer);
		System.out.println("Enter the numbe of " + theItem.getItemName() + "(s) to buy: ");
		String qtyAnswer = this.input.nextLine();
		int qty = Integer.parseInt(qtyAnswer);
		this.theShopper.haveEnoughToBuy(theItem, qty);
		this.theShopper.addItem(theItem, qty);
		System.out.println("You have added " + qty + " " + theItem.getItemName() + "(s) to your cart.");
		System.out.println("You have " + this.theShopper.getAmountToSpend() + " to spend");
	}
	
	private void viewCart() {
		this.theShopper.getCart();
	}
	
	private void viewMoney() {
		System.out.println("Amount remaining to spend: " + this.theShopper.getAmountToSpend());
	}
	
	private void checkout() {
		this.theShopper.purchaseCart();
	}
	
	
}
