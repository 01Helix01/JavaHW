package inclass.example.genericLists;

public interface MyList<E> {

	public boolean isEmpty();
	
	public boolean search(E key);
	
	public void print();
	
	public int getSize();
	
	public void addFirst(E s);
	
	public void addLast(E s);
	
	public void removeFirst();
	
	public void removeLast();
	
	
}
