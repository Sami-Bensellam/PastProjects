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
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);  
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
Point[] arr1 = new Point[pts.length/2];
Point[] arr2 = new Point[pts.length-(pts.length/2)];
if (1 < pts.length) {
		      for(int i = 0; i<pts.length/2;i++) {
		    	  arr1[i] = pts[i];
		      }

		      for(int i = pts.length/2; i<pts.length;i++) {
		    	  arr2[i-pts.length/2] = pts[i];
		      }
				      
				      // Recursively sort left and right partitions
				      mergeSortRec(arr1);
				      mergeSortRec(arr2);
				      
				      // Merge left and right partition in sorted order
				      merge(pts,arr1,arr2);//calls merge to merge the 2 arrays into pts
	if(pts.length == points.length) {//checks if pts length reaches points length if so it deep copies pts to points 
		for(int i =0;i<points.length;i++) {
			points[i] = pts[i];
		}
	}
	}

	}
	
	// Other private methods if needed ...
	 private void merge(Point[] pts, 
             Point[] left, Point[] right) {
int i1 = 0;   // index into left array
int i2 = 0;   // index into right array

for (int i = 0; i < pts.length; i++) {
if (i2 >= right.length || (i1 < left.length &&(pointComparator.compare(left[i1],right[i2])<1))) {//checks if right array length is greater or equal to right length or i1 is less than left length and left is greater than right
pts[i] = left[i1];    // take from left
i1++;// adds 1 to left array index
} else {
pts[i] = right[i2];   // take from right
i2++;//adds 1 to the right index
}
}		
	}
}
