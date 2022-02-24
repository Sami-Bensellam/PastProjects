package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author 
 *
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner  
{
	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;    
	
		
	protected long scanTime; 	       // execution time in nanoseconds. 
	
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
	if(pts == null || pts.length==0) {
		throw new IllegalArgumentException();
	}
	points = new Point[pts.length];
	for(int i = 0 ;i<pts.length;i++) {
		points[i] = pts[i];
	}
	sortingAlgorithm = algo;
	}

	
	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		ArrayList<Point> pointlist = new ArrayList<Point>();
		File file = new File(inputFileName);
		try (Scanner sc = new Scanner(file)) {
			int x, y;
			while(sc.hasNextLine()){
				while(sc.hasNext()) {				
					x = sc.nextInt();
					if(sc.hasNext() == false) {
						throw new InputMismatchException();
					}
					y = sc.nextInt();
					Point newpt = new Point(x,y);
					pointlist.add(newpt);
				}
			}
			points = new Point[pointlist.size()];
			for(int i = 0; i<pointlist.size();i++) {
			points[i] = pointlist.get(i);

			}
			sortingAlgorithm = algo;
sc.close();
		}
	}
	
	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * @param algo
	 * @return
	 */
	public void scan()
	{
		AbstractSorter aSorter = null;
		if(sortingAlgorithm == Algorithm.InsertionSort) {//checks which sorting algorithm is used an initializes abstract sorter to the specific kind
			aSorter = new InsertionSorter(points); 
		}
		else if(sortingAlgorithm == Algorithm.MergeSort) {
			aSorter = new MergeSorter(points); 
		}

		else if(sortingAlgorithm == Algorithm.QuickSort) {
			aSorter = new QuickSorter(points); 
		}

		else if(sortingAlgorithm == Algorithm.SelectionSort) {
			aSorter = new SelectionSorter(points); 
		}
		aSorter.setComparator(0);
		long timeStart = System.nanoTime();//gets the start time
		aSorter.sort();
		long timeEnd = System.nanoTime();//gets the end time
//		aSorter.getPoints(points);
		
		Point medianpoint = aSorter.getMedian();//gets the median of the sorted asorter with the x variable
		aSorter.setComparator(1);//does the same thing but now it sorts points by the y variable instead 
		long timeStart2 = System.nanoTime();
		aSorter.sort();
		long timeEnd2 = System.nanoTime();
		//aSorter.getPoints(points);

		Point medianpoint2 = aSorter.getMedian();
		medianCoordinatePoint = new Point(medianpoint.getX(),medianpoint2.getY());//gets the median point of the first sorted array using x and same thing with y and only gets the x and the y and intializes a new point with both
		
		scanTime = (timeEnd-timeStart)+(timeEnd2-timeStart2);//gets the difference of the first and second sorts and adds them together to get the total scantime
		
		// create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two 
		// rounds of sorting, have aSorter do the following: 
		// 
		//     a) call setComparator() with an argument 0 or 1. 
		//
		//     b) call sort(). 		
		// 
		//     c) use a new Point object to store the coordinates of the medianCoordinatePoint
		//
		//     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
		//
		//     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime. 
		
	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		String sortname = null;
		if(sortingAlgorithm == Algorithm.InsertionSort) {//checks which sorting algorithm is used and itlizes that to return a string with it's name
			sortname = "InsertionSort"; 
		}
		else if(sortingAlgorithm == Algorithm.MergeSort) {
			sortname = "MergeSort    "; 
		}

		else if(sortingAlgorithm == Algorithm.QuickSort) {
			sortname = "QuickSort    "; 
		}

		else if(sortingAlgorithm == Algorithm.SelectionSort) {
			sortname = "SelectionSort"; 
		}
		return sortname+"   "+points.length+"	  "+scanTime; 
	}
	
	
	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		return "MCP: "+medianCoordinatePoint.toString(); 
	}

	
	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException
	{
		File outPutFileName = new File("Output.txt");//initializes a new file with file name
		try {
			outPutFileName.createNewFile();//creates the file
		} catch (IOException e) {
			throw new FileNotFoundException();

		}
		try {
			FileWriter myWriter = new FileWriter("Output.txt");//initializes a new writer to output.txt
			myWriter.write(toString());//writes onto the file the mcp
			myWriter.close();//closes the writer
//			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			throw new FileNotFoundException();
		}
	}

	
}	

	

		

