package edu.iastate.cs228.hw3;
//@author SamiBensellam
public class stack {
    private Node head; // the first node
 
    private class Node {//node class for usage
        String value;
        Node next;
    }
 
    public stack() {//we are using a singly linked list
        head = null;//setting the head to null once we create it
    }
 
    public String pop()  {//we remove the head value and set the next as the new head value
        if (head == null) {
        String value;
        }
        String value = head.value;
        head = head.next;
        return value;//return the removed head value
    }
    public boolean isEmpty() {//checks if head is null if head is null it means that the linked list is empty
    	if(head == null) {
    		return true;
    }
    	return false;
    }
    public String peek() {//returns the head value without chanfing anything
    	return head.value;
    }
 
    // Add value to the beginning of the list for demonstrating behaviour of stack
    public void push(String value) {
        Node oldHead = head;//creates a node that stores the old head and sets that as the next
        head = new Node();
        head.value = value;//makes the new head the new value
        head.next = oldHead;
    }
}
