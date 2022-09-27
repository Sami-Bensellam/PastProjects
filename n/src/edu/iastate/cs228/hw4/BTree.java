package edu.iastate.cs228.hw4;
import java.util.ArrayList;
//@Author SamiBensellam
public class BTree {
	MsgTree prevNode = null;//setting previous node
	MsgTree Root = null;//setting root
	String input;//setting input
	String output = "";//setting output
	int l = 0;
	ArrayList<String> Rmap = null;
	
	
	public BTree(String input) {
		Root = new MsgTree(input.charAt(0), null);	
		MsgTree prevNode = Root;
		MsgTree currNode = null;


		for (int i = 1; i<input.length();i++) {//loops through the input string until the tree is full
			currNode = new MsgTree(input.charAt(i), prevNode);//the position we are iterating in the for loop
			if(prevNode.left == null) {//checks if the left node is null
				prevNode.setleft(currNode);//sets the left node as currnode
				if(currNode.value == '^') {//checks if the node value is a cone if it is than it sets it as the previous value
					prevNode = currNode;
				}
			}
			else {
				prevNode.serright(currNode);//if the left pointer is already assigned it sets the right pointer as the new node
				if(currNode.value() == '^') {//if it is a cone it sets the previous as the current node
					prevNode = currNode;
				}
				else {
					while(prevNode.parent != null && prevNode.right != null) {//sets the previous node as the last parent that has the right spot available
						prevNode = prevNode.parent;
					}
				}
			}
		}
	}
	
	
	public void decode(MsgTree Root, String input) {

		this.input = input;
		while(l < input.length()) {//iterates until l reaches the input length
			findletter(Root, l);
		}
		System.out.println(output);//prints out the decoded string
	}




	void findletter(MsgTree node, int o) {
		if(node.value() != '^') {
			output += node.value;
//			System.out.print(node.value);
			return;
		}
		else {
			try {
			if (input.charAt(o) == '0') {//checks if the next character is 0 if it is it goes to the left pointer of the node
				l++;
				findletter(node.left, l);
			}
			else {//else it goes into the right pointer of the node
				l++;
				findletter(node.right, l);
			}
			return;
			}
			catch (IndexOutOfBoundsException e) {
				
			}
			}
	}

	public void printCodes() {
		Rmap = new ArrayList<String>();//creates an arraylist where I store the value in the leaf and then the code of that value in that order
		iterateNode(Root, "");
		System.out.println("character code");
		System.out.println("-------------------------");
		for(int i = 0;i<Rmap.size();i++) {
			System.out.println("   "+Rmap.get(i)+"       "+Rmap.get(i+1));
			i++;
		}

	}	

	private void iterateNode(MsgTree node,String iter) {//recursive function that iterates through the code until it hits a leaf and once it does it adds the leaf value and the code
		if(node.value != '^') {
			Rmap.add(node.value()+"");
			Rmap.add(iter);
		}
		else {
			iterateNode(node.left, iter+"0");
			iterateNode(node.right,iter+"1");
		}

	}

}

