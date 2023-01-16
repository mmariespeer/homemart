package edu.westga.cs6311.homemart.model;
import java.util.ArrayList;
/**
 * The shopper class outlines parameters and methods to be used with the InventoryItem class to
 * allow shoppers to buy item's off the inventory list.
 * @author Melissa Speer Osborne
 * @version 12/5/2016
 */
public class Shopper {
	private String name;
	private double moneyToSpend;
	private ArrayList<InventoryItem> itemsInCart;

	/**
	 * Create customer based on name and money to spend, create cart
	 * @param name as a String
	 * @param moneyToSpend as a double
	 */
	public Shopper(String name, double moneyToSpend) {
		if (name == null) {
			this.name = "";
		} else {
			this.name = name;
		}
		if (moneyToSpend <= 0) {
			this.moneyToSpend = 0;
		} else {
			this.moneyToSpend = moneyToSpend;
		}
		this.itemsInCart = new ArrayList<InventoryItem>();
	}

	/**
	 * Get the customer's name
	 * @return the customer's name as a string
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get amount the customer has to spend
	 * @return the amount of money the customer has as a double
	 */
	public double getAmountToSpend() {
		return this.moneyToSpend;
	}

	/**
	 * Get all item's in the cart and show on screen
	 * @return the list of item's in the cart
	 */
	public String getCart() {
		if (this.itemsInCart.isEmpty()) {
			System.out.println("There are no items in your cart.\n");
		}
		String listedCartItems = "";
		
		for (InventoryItem current : this.itemsInCart) {
			listedCartItems += current.toString();
		}
		return listedCartItems;
	}
	
	/**
	 * Check the customers amount to spend and the cost of the item. If the 
	 * customer has enough money, return true.
	 * @param theItemToBuy the InventoryItem to be bought
	 * @param qty the quantity to be purchased
	 * @return boolean value of true or false
	 */
	public boolean haveEnoughToBuy(InventoryItem theItemToBuy, int qty) {
		double cost = theItemToBuy.getItemCost() * qty;
		double money = this.getAmountToSpend();
		return cost <= money;
	}
	
	/**
	 * Add an item to the cart, subtract the qty from the inventory and the amount spent
	 * from customers "moneyToSpend" amount.
	 * @param theItem the InventoryItem to be bought
	 * @param qty the qty to be bought
	 */
	public void addItem(InventoryItem theItem, int qty) {
		if (this.haveEnoughToBuy(theItem, qty)) {
			return;
		}
		
		if (theItem.getItemQuantity() < qty) {
			return;
		}
		theItem.setItemQuantity(theItem.getItemQuantity() - qty);
		this.moneyToSpend = this.moneyToSpend - (theItem.getItemCost() * qty);
		this.itemsInCart.add(new InventoryItem(theItem.getItemName(), theItem.getItemCost(), qty));
		
	}

	/**
	 * Clear the shopping cart
	 */
	public void purchaseCart() {
		this.itemsInCart.clear();
	}
	
}
