package inclass.example.genericLists;

public class MyQueue<E> implements MyList<E>{
	
	private MyLinkedList<E> myqueue = new MyLinkedList<>();
	
	public boolean isEmpty() {
		return myqueue.isEmpty(); 
	}
	
	public void enqueue (E s) {
		myqueue.addLast(s);
	}
	
	public void dequeue() {
		myqueue.removeFirst();
	}
	
	public void print() {
		myqueue.print();
	}

	
	// Interface methods
	
	@Override
	public boolean search(E key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		return myqueue.getSize();
	}

	@Override
	public void addFirst(E s) {
		myqueue.addFirst(s);
	}

	@Override
	public void addLast(E s) {
		myqueue.addLast(s);
	}

	@Override
	public void removeFirst() {
		myqueue.removeFirst();
	}

	@Override
	public void removeLast() {
		myqueue.removeLast();
	}
}
