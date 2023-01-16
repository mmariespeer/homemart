package edu.westga.cs6311.homemart.controller;
import edu.westga.cs6311.homemart.view.HomemartTUI;
import edu.westga.cs6311.homemart.model.Inventory;

/**
 * The driver of the Homemart Application
 * @author Melissa Speer Osborne
 * @version 12/4/2016
 */
public class HomemartDriver {
	
	/**
	 * The entry point of the application
	 * @param args no arguments
	 */
	public static void main(String[] args) {
		Inventory list = new Inventory();
		HomemartTUI tuiHomemart = new HomemartTUI(list);
		tuiHomemart.runHomemart();

	}

}
