package inclass.example.genericLists;

public class MyStack<E> implements MyList<E>{
	
	private int top;
	private MyLinkedList<E> mystack = new MyLinkedList<>();
	
	public boolean isEmpty() {
		return mystack.isEmpty();
	}
	
	public void push(E s) {
		mystack.addFirst(s);
		top = mystack.getSize();
	}
	
	public E peek() {
		return mystack.getFirstElement();
	}
	
	public void pop() {
		mystack.removeFirst();
		top = mystack.getSize();
	}
	
	public boolean search(E key) {
		return mystack.search(key);
	}
	
	public void print() {
		mystack.print();
	}

	@Override
	public int getSize() {
		return mystack.getSize();
	}

	@Override
	public void addFirst(E s) {
		mystack.addFirst(s);
		
	}

	@Override
	public void addLast(E s) {
		mystack.addLast(s);
		
	}

	@Override
	public void removeFirst() {
		mystack.removeFirst();
		
	}

	@Override
	public void removeLast() {
		mystack.removeLast();
		
	}
	
}
