import java.util.*;
import java.lang.*;
import java.io.*;

class MyLinkedList{

	private Node first;
	private Node last;
	private int size;

	/**
	 * add element e to the end of the linkedlist 
	 * @param e
	 */
	public void addLast(int e){
		Node newNode = new Node(e);
		if(first == null && last==null){
			first = newNode;
		}else{
			last.setNext(newNode);
		}
		last = newNode;
		size++;
	}
	
	public Node getHead(){
		return this.first;
	}

	public int getSize(){
		return this.size;
	}
}

class Node {

	private int element;
	private Node next;

	public Node(int e){
		this.element = e;
	}
	public int getElement() {
		return element;
	}
	public Node getNext() {
		return next;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}