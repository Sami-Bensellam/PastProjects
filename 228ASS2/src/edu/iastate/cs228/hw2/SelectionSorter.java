package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author SamiBensellam
 *
 */

/**
 * 
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 

	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts  
	 */
	public SelectionSorter(Point[] pts)  
	{
		super(pts);  
	}	


	/** 
	 * Apply selection sort on the array points[] of the parent class AbstractSorter.  
	 * 
	 */
	@Override 
	public void sort()
	{
		int minVal;

		for(int i = 0; i<points.length;i++) {//iterates through the list
			minVal = i;//sets the minimum value to i 
			for(int j = i; j<points.length;j++) {//iterates from i which is the value reached in our array
				if(pointComparator.compare(points[minVal],points[j])==1) {//compares to see if anything is smaller than the minimum value
					minVal = j;//changes the minimum value to the value smaller
				}
			}
			swap(i,minVal);//swaps the array positions to have the smaller value
		}
	}	
}
