package edu.iastate.cs228.hw2;

/**
 *  
 * @author SamiBensellam
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{		
		// 
		// Conducts multiple rounds of comparison of four sorting algorithms.  Within each round, 
		// set up scanning as follows: 
		// 
		//    a) If asked to scan random points, calls generateRandomPoints() to initialize an array 
		//       of random points. 
		// 
		//    b) Reassigns to the array scanners[] (declared below) the references to four new 
		//       PointScanner objects, which are created using four different values  
		//       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort. 
		// 
		// 	

		try {

			Random random = new Random();
			PointScanner[] scanners = new PointScanner[4]; 
			Scanner sc = new Scanner(System.in);
			System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
			System.out.println();
			System.out.println("keys:  1 (random integers)  2 (file input)  3 (exit)");
			for(int t =0;t<2;t++) {
				System.out.print("Trial "+(t+1)+":");
				int userInput = sc.nextInt();
				System.out.println();
				if(userInput == 3) {
				}
				else if(userInput == 1) {//if user chooses 1 it asks for random points
					System.out.print("Enter number of random points:");
					int userInput2 = sc.nextInt();
					System.out.println("");
					Point[] newPoint = generateRandomPoints(userInput2,random);
					scanners[0] = new PointScanner(newPoint,Algorithm.SelectionSort);
					scanners[1] = new PointScanner(newPoint,Algorithm.InsertionSort);
					scanners[2] = new PointScanner(newPoint,Algorithm.MergeSort);
					scanners[3] = new PointScanner(newPoint,Algorithm.QuickSort);
					System.out.println("algorithm   size  time (ns) ");
					System.out.println("---------------------------------- ");
					for(int i = 0; i<4;i++) {
						scanners[i].scan();
						System.out.println(scanners[i].stats());
					}
					System.out.println("---------------------------------- ");
					scanners[2].writeMCPToFile();
				}
				else if(userInput == 2) {
					System.out.print("File name:");
					String userInput3 = sc.next();
					System.out.println();
					scanners[0] = new PointScanner(userInput3,Algorithm.SelectionSort);
					scanners[1] = new PointScanner(userInput3,Algorithm.InsertionSort);
					scanners[2] = new PointScanner(userInput3,Algorithm.MergeSort);
					scanners[3] = new PointScanner(userInput3,Algorithm.QuickSort);
					System.out.println("algorithm   size  time (ns) ");
					System.out.println("---------------------------------- ");
					for(int i = 0; i<4;i++) {
						scanners[i].scan();
						System.out.println(scanners[i].stats());

					}
					System.out.println("---------------------------------- ");

					scanners[2].writeMCPToFile();
				}
			}
			sc.close();
		}
		catch(Exception ex) {

			System.out.print(ex.toString());
		}
		// For each input of points, do the following. 
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() 
		//        method in the PointScanner class.  
		//
		//     c) After all four scans are done for the input, print out the statistics table from
		//		  section 2.
		//
		// A sample scenario is given in Section 2 of the project description. 

	}


	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] � [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		if(numPts < 1) {
			throw new IllegalArgumentException();
		}
		int x,y;
		Point[] newPoint = new Point[numPts];
		for(int i =0; i<numPts;i++) {
			x = rand.nextInt(101) - 50;
			y = rand.nextInt(101) - 50;
			newPoint[i] = new Point(x,y);
		}

		return newPoint; 
	}

}
