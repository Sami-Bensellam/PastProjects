package edu.iastate.cs228.hw4;
//@Author SamiBensellam

public class MsgTree {//node constructor 
	MsgTree left = null;//stores left node and right node
	MsgTree right = null;
	MsgTree parent = null;
	char value;
	
	public MsgTree(char inValue, MsgTree parent) {
		this.parent = parent;//stores parent variable and value
		this.value = inValue;
	}
	void setleft(MsgTree l){
		this.left = l;
	}
	void serright(MsgTree r) {
		this.right = r;
	}
	MsgTree nextl() {
		return left;
	}
	MsgTree nextr() {
		return right;
	}
	char value() {
		return value;
	}
}
