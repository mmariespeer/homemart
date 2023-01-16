package edu.westga.cs6311.homemart.model;
import java.util.ArrayList;
/**
 * The Inventory Class creates an ArrayList of InventoryItem's and provides 
 * methods for analyzing those objects within the list
 * @author Melissa Speer Osborne
 * @version 12/4/2016
 */
public class Inventory {
	private ArrayList<InventoryItem> inventoryList;
	
	/**
	 * Create an ArrayList of InventoryItem objects
	 */
	public Inventory() {
		this.inventoryList = new ArrayList<InventoryItem>();
	}
	
	/**
	 * Add two InventoryItem objects to the ArrayList
	 */
	public void openStore() {
		this.inventoryList.add(new InventoryItem("Hammer", 9.99, 5));
		this.inventoryList.add(new InventoryItem("Nails", 0.98, 100));
	}
	
	/**
	 * Search the ArrayList for a specific item
	 * @param item as a string, the item to be searched for
	 * @return the InventoryItem object that was searched for
	 */
	public InventoryItem findItem(String item) {
		InventoryItem foundItem = new InventoryItem("null", 0, 0);
		for (InventoryItem current : this.inventoryList) {
			if (current.getItemName().equalsIgnoreCase(item)) {
				return current;
			}
		} return foundItem;
	}
	
	/**
	 * Add an item to the ArrayList
	 * @param name the name of the item as a string
	 * @param cost the cost of the item as a double
	 * @param qty the quantity of the item as an integer
	 */
	public void addItem(String name, double cost, int qty) {
		InventoryItem newItem = new InventoryItem(name, cost, qty);
		this.inventoryList.add(newItem);
	}
	
	/**
	 * Search the ArrayList for the cheapest InventoryItem object
	 * @return the InventoryItem object that has the lowest cost
	 */
	public InventoryItem getCheapestItem() {
		InventoryItem cheapItem = this.inventoryList.get(0);
		for (InventoryItem current : this.inventoryList) {
			if (current.getItemCost() < cheapItem.getItemCost()) {
				cheapItem = current;
			}	
		} return cheapItem;
	}
	
	/**
	 * Search the ArrayList for the most expensive InventoryItem object
	 * @return the InventoryItem object that has the highest cost
	 */
	public InventoryItem getMostExpensiveItem() {
		InventoryItem priceyItem = this.inventoryList.get(0);
		for (InventoryItem current : this.inventoryList) {
			if (current.getItemCost() > priceyItem.getItemCost()) {
				priceyItem = current;
			}
		} return priceyItem;
	}
	
	/**
	 * Calculate the total number of each item's quantities added together
	 * @return the sum of all the item's quantities
	 */
	public int getTotalQuantity() {
		int sum = 0;
		for (InventoryItem current : this.inventoryList) {
			sum += current.getItemQuantity();
		} return sum;
	} 
	
	/**
	 * Calculate the average cost of all the InventoryItem's in the ArrayList
	 * @return the average cost as a double (not rounded)
	 */
	public double getAverageCost() {
		double sum = 0;
		for (InventoryItem current : this.inventoryList) {
			sum += current.getItemCost();
		} double average = sum / this.inventoryList.size();
		return average;
	}
	
	/**
	 * A method to create a string of information about the InventoryItem's in the ArrayList formatted
	 * to be more easily viewed by the user.
	 * @return a string of information
	 */
	public String toString() {
		String inventoryBreakDown = "";
		if (this.inventoryList.isEmpty()) {
			System.out.println("No items in stock");
		} else {
		
		
			for (InventoryItem current : this.inventoryList) {
				inventoryBreakDown += current.toString() + "\n";
			}
			inventoryBreakDown = inventoryBreakDown + "\nNumber of items: " + this.inventoryList.size() 
				+ "\nTotal quantity of all items: " + this.getTotalQuantity() 
				+ "\nMost Expensive Item: " + this.getMostExpensiveItem().toString() 
				+ "\nLeast Expensive Item: " + this.getCheapestItem().toString()
				+ "\nAverage item Cost: $" + String.format("%1.2f", this.getAverageCost()) + "\n";
		} 
		return inventoryBreakDown;
	
	} 
}
	
