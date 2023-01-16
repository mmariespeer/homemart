package edu.westga.cs6311.homemart.model;
/**
 * This class outlines parameters for items to be placed into an ArrayList to create an inventory
 * @author Melissa Speer Osborne
 * @version 12/4/2016
 */
public class InventoryItem {
	private String itemName;
	private double itemCost;
	private int itemQuantity;
	
	/**
	 * Create a new InventoryItem object based on 3 parameters
	 * @param itemName as a String
	 * @param itemCost as a double
	 * @param itemQuantity as an integer
	 */
	public InventoryItem(String itemName, double itemCost, int itemQuantity) {
		if (itemName == null) {
			this.itemName = "";
		} else {
			this.itemName = itemName;
		}
		if (itemCost < 0) {
			this.itemCost = 0;
		} else {
			this.itemCost = itemCost;
		}
		if (itemQuantity < 0) {
			this.itemQuantity = 0;
		} else {
			this.itemQuantity = itemQuantity;
		}
	}
	
	/**
	 * Get the InventoryItem's name
	 * @return the item's name as a string
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * Get the InventoryItem's cost
	 * @return the item's cost as a double
	 */
	public double getItemCost() {
		return this.itemCost;
	}
	
	/**
	 * Get the InventoryItem's quantity
	 * @return the item's quantity as an integer
	 */
	public int getItemQuantity() {
		return this.itemQuantity;
	}

	/**
	 * Set the item's quantity to a new value
	 * @param itemQuantity new quantity for the item
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	/**
	 * Subtract the purchased quantity from the current quantity
	 * @param quantityToBuy the quantity as an integer to be purchased
	 */
	public void purchaseItem(int quantityToBuy) {
		if (quantityToBuy > 0 && this.getItemQuantity() > quantityToBuy) {
			int current = this.getItemQuantity();
			this.setItemQuantity(current - quantityToBuy);
		} else {
			System.out.println("There is not enough inventory.\n");
		}
	}

	/**
	 * Method to output each InventoryItem in a specific format
	 * @return a String output of the InventoryItem
	 */
	public String toString() {
		String output = String.format("%1$-10s" + "$" + "%2$.2f" + " Quantity:" + "%3$3d", this.itemName, this.itemCost, this.itemQuantity); 
		return output;
	}
	
	
	
}
