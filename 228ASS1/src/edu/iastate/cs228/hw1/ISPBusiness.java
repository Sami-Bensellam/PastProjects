package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for(int i = 0 ; i < tNew.getLength(); i++) {
			for(int j = 0 ; j < tNew.getWidth(); j++) {
				tNew.grid[i][j] = tOld.grid[i][j].next(tOld);
				
			}
		}
		
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		for(int i = 0 ; i < town.getLength(); i++) {
			for(int j = 0 ; j < town.getWidth(); j++) {
			
				if(town.grid[i][j].who() == State.CASUAL) {
				profit++;
			}
			
			}
			}
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 * 
	 */
	public static void main(String []args) throws FileNotFoundException {
//		Town weewee = new Town("/Users/samibensellam/Desktop/courses/Comp sci 228/Assignment1/ISP4x4.txt");
		Town weewee = new Town(4,4);
		weewee.randomInit(10);
		System.out.println(weewee.toString());
		System.out.println("Profit:"+getProfit(weewee));
		int l = 1;
		for (int i =0; i< 7;i++) {
			Town TownNew = updatePlain(weewee);
			System.out.println(TownNew.toString());
			System.out.println("Profit:"+getProfit(TownNew));
			System.out.println("After itr:"+ l);
			l++;
			weewee = TownNew;
		}
		
	}
}
