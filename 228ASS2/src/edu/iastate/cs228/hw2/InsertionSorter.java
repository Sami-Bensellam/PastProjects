package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);  
	}	

	
	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	public void sort()
	{
			  int i = 0;
			  int j = 0;
			   
			   for (i = 1; i < points.length; ++i) {
			      j = i;
			      // Insert numbers[i] into sorted part
			      // stopping once numbers[i] in correct position
			      while (j > 0 && pointComparator.compare(points[j],points[j - 1])==-1) {//runs until the value is greater than the one before it or reaches zero
			         
			    	  swap(j,j-1);
			         --j;
			      }
			   }
			}
	}		

