package edu.iastate.cs228.hw3;
//@author SamiBensellam 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InfixtoPostfix {

	public static String InfPost(String inputFile){
		String lastop = "";//sets the string for the last operator
		String lastand = "";//sets the string for the last operand
		String output = "";//sets the string for the output
		Scanner sc;//sets the scanner
		stack op = new stack();
		String NXT = null;
		boolean cor = true;
			sc = new Scanner(inputFile);
		
			while (sc.hasNext()) {//checks if there is another value
				if (sc.hasNextInt()) {//checks if the next variable is an operand which is given as an int
					if(!cor) {//checks if there are two ints in a row
						return "Error: too many operands ("+sc.next()+")";//returns the string with the exception
					}
					NXT = sc.next();
					output = output + NXT+" ";
					cor = false;
					lastand = NXT;
				}
				else {
					NXT = sc.next();

					if(NXT.equals("(")) {
										if(cor == false) {
											return "Error: too many operands ("+lastand+")";
										}
						op.push(NXT);
					}
					else {
						if(NXT.equals(")")){
							if(op.peek().equals("(")) {
								return "Error: no subexpression detected ()";
							}
							while(!op.isEmpty()) {
								if(op.peek().equals("(")) {
									op.pop();
									break;
								}
								output += op.pop()+ " ";
								if(op.isEmpty()) {
									return "Error: no opening parenthesis detected ";
								}
							}
							if (cor) {
								return "Error: too many operators ("+lastop+") ";
							}



						}
						else {
							if (cor) {//checks if the last character is a operator
								return "Error: too many operators ("+NXT+") ";
							}
							while(!op.isEmpty() && compare(op.peek(), NXT)>-1) {
								output += op.pop()+ " ";
							}
							lastop = NXT;
							op.push(NXT);
							cor = true;

						}
					}
				}
			}
			if (cor) {//checks if the last character is an operator
				return "Error: too many operators ("+lastop+") ";
			}
			while (!op.isEmpty()) {//goes through a while loop until the operator stack is empty
				output += op.pop()+ " ";
			}
			sc.close();
//		catch (FileNotFoundException e) {//Catches the file not found exception and throws a stack trace since it makes it easy for me to figure out the problem and there are no specification of what is to be thrown 
//			e.printStackTrace();
//		}
		return output;//returns the string created if there are no exceptions encountered
	}
	
	
	public static int compare(String i, String o) {
		int i1 = 0, i2 = 0;
		if(i.equals("^") && o.equals("^")) {//checks if the numbers being compared are ^ because they are right associative
			return -1;
		}
		if(i.equals("-") || i.equals("+")) {//puts the operators into a higherarchy by introducing a new int variable and assigns it with a number it will be greater if the value is greater
			i1 = 1;
		}
		if(i.equals("/") || i.equals("*") || i.equals("%")) {
			i1 = 2;
		}
		if(i.equals("^")) {
			i1 = 3;
		}
		if(i.equals(")")) {
			i1 = 0;
		}
		//
		if(o.equals("-") || o.equals("+")) {
			i2 = 1;
		}
		if(o.equals("/") || o.equals("*") || o.equals("%")) {
			i2 = 2;
		}
		if(o.equals("^")) {
			i2 = 3;
		}
		if(o.equals(")")) {
			i2 = 0;
		}
		if(i2>i1) {//checks if the first number's hierarchy is greater than the 2nd
			return -1;
		}
		if(i2<i1) {//same here 
			return 1;
		}
		if(i2==i1) {//same here
			return 0;
		}
		return 2;
	}

	
public static void main(String args[]) throws FileNotFoundException 
{
	File inputFile = new File("Input.txt");//scans the Input.txt file
	String infixed = "";
	Scanner scan = new Scanner (inputFile);
	File outPutFileName = new File("Output.txt");//initializes a new file with file name
	try {
		outPutFileName.createNewFile();//creates the file
	} catch (IOException e) {
		throw new FileNotFoundException();
	
	}
	try {
		FileWriter myWriter = new FileWriter("Output.txt");//initializes a new writer to output.txt
		while(scan.hasNextLine()) {
			infixed = scan.nextLine();
			String Infixed = InfPost(infixed);
		myWriter.write(Infixed);//writes onto the file the postfix expression
		myWriter.write("\r\n");
		}
		myWriter.close();//closes the writer
	} catch (IOException e) {
		throw new FileNotFoundException();
	}


}
}