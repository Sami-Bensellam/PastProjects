package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author Sami Bensellam
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{

	// Other private instance variables if you need ... 

	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		super(pts);
	}


	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{	 
		quickSortRec(0,(points.length)-1);
	}


	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		int midpoint;
		if(first < last) {
			midpoint = partition(first, last);//calls partition which swaps the array 
			quickSortRec(first,midpoint);//recursively call this function on the first half 
			quickSortRec(midpoint+1,last);//recursively call this function on the 2nd half
		}
	}


	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{

		Point pivot = points[first+((last-first)/2)];//I am using the midpoint as my pivot
		boolean key = true;
		while(key) {

			while(pointComparator.compare(pivot,points[first]) == 1) {//I go iterate through the list until I find a variable bigger than the pivot
				first += 1;
			}
			while(pointComparator.compare(pivot,points[last]) == -1) {//same thing but I go down instead but this time from the front
				last -= 1;
			}

			if(first>=last) {//if the first aand last meet the loop ends
				break;

			}
			this.swap(first,last);//if the first is bigger than the pivot and the last is smaller I swap them
			first++;
			last--;
		}

		return last; //I return the new midpoint
	}	




	// Other private methods if needed ...
}
