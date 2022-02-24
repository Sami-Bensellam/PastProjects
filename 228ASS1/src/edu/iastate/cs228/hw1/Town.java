package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 *  @author <<Write your name here>>
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		
		File inputFile = new File(inputFileName);
		Scanner newsc = new Scanner(inputFile);
//		String lenwid = newsc.nextLine();
//		System.out.println("this is lenwid "+lenwid);
//		this.length = Integer.parseInt(lenwid.split(" +")[0]);
//		this.width = Integer.parseInt(lenwid.split(" +")[1]);
		length = newsc.nextInt();
		width = newsc.nextInt();
		//System.out.println(length+" "+width);

		//Town f = new Town(length, width); 

		grid = new TownCell[length][width];
		//System.out.println(grid.length);
		//System.out.println(grid[0].length);

		for(int i = 0; i<length;i++) {
//			String Line = newsc.nextLine();
//			System.out.println(Line);
			for(int j =0;j<width;j++) {
				char svalue = newsc.next().charAt(0);
				//char svalue = Line.charAt(j*2);
				if (svalue == 'C') {
					grid[i][j] = new casual(this, i, j);
				}
				if (svalue == 'E') {
					grid[i][j] = new empty(this, i, j);
				}
				if (svalue == 'O') {
					grid[i][j] = new outage(this, i, j);
				}
				if (svalue == 'R') {
					grid[i][j] = new reseller(this, i, j);
				}
				if (svalue == 'S') {
					grid[i][j] = new streamer(this, i, j);
				}
			}
		}

	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		for (int i = 0; i < length; i++) {		
			for(int j = 0; j < width; j++) {
				int newRandomvalue = rand.nextInt(5);
				if (newRandomvalue == TownCell.CASUAL) {
					casual c = new casual(this, i, j);
					grid[i][j] = c;
				}
				if (newRandomvalue == TownCell.EMPTY) {
					empty e = new empty(this, i, j);
					grid[i][j] = e;
				}
				if (newRandomvalue == TownCell.OUTAGE) {
					outage o = new outage(this, i, j);
					grid[i][j] = o;
				}
				if (newRandomvalue == TownCell.RESELLER) {
					grid[i][j] = new reseller(this, i, j);
				}
				if (newRandomvalue == TownCell.STREAMER) {
					streamer s = new streamer(this, i, j);
					grid[i][j] = s;
				}

}
}
}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < length;i++) {
			for (int j = 0; j < width; j++) {

				if(grid[i][j].who() == State.CASUAL) {
					s = s + "C ";
				}
				if(grid[i][j].who() == State.EMPTY) {
					s = s + "E ";
				}
				if(grid[i][j].who() == State.OUTAGE) {
					s = s + "O ";
				}
				if(grid[i][j].who() == State.RESELLER) {
					s = s + "R ";
				}
				if(grid[i][j].who() == State.STREAMER) {
					s = s + "S ";
				}

			}
			s = s + "\n";
		}
		return s;
	}
	
	
}

