package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;

public class test {
	public static void main(String[] args) throws FileNotFoundException
	{
		Point[] r = new Point[5];
		r[0] = new Point(1000,90); 
		r[1] = new Point(1000,809); 
		r[2] = new Point(0,9000); 
		r[3] = new Point(1000,1000); 
		r[4] = new Point(1000,46); 
		

		AbstractSorter o = new QuickSorter(r);
		o.setComparator(0);
		o.sort();
		for(int i =0;i<5;i++) {
		System.out.println(o.points[i].toString());
	}}

}
