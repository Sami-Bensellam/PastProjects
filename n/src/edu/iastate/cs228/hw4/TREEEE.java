package edu.iastate.cs228.hw4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//@author SamiBensellam

public class TREEEE {
	public static void main(String[] args) {  
Scanner SI = new Scanner(System.in);
System.out.println("Please enter filename to decode:  ");
File file = new File(SI.next());
Scanner sc;
int l = 0;
try {
	sc = new Scanner(file);
	String ip = "";
do {//goes into a while loop adding into a string until the next String is an int which means it is the code to decode
	if(l>0) {
		ip += '\n';//each time it is a newline we add a newline character to the string
	}
	ip += sc.nextLine();
	l++;
}
while(!sc.hasNextBigInteger());//checks if the next is a big integer because int is too small
	BTree no = new BTree(ip);
	ip = sc.nextLine();
no.printCodes();
System.out.println("MESSAGE: ");
no.decode(no.Root,ip);//decodes the value starting with the root
sc.close();
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
SI.close();
}

}