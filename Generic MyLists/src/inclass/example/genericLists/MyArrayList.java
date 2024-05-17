package inclass.example.genericLists;

public class MyArrayList<E> implements MyList<E>{

	private Object[] list;
	private int capacity = 4;
	private int size;
	
	public MyArrayList() {
		this(4);
	}
	
	public MyArrayList(int capacity) {
		if (capacity > 4)
			this.capacity = capacity;
		this.list = new Object[this.capacity];
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// add element in the end of list
		public void addLast(E s) {
		if(size >= capacity) resize(this.capacity * 2);
		list[size] = s;
		size++;
	}
		
	
		
	// it can act like adding element to the beginning of your list
	public void addFirst(E s, int index) {
		if(index >= 0 && index <= size) {
			if(size >= capacity) resize(this.capacity * 2);
			for(int k = size - 1; k >= index; k--) {//shifting element
				list[k+1] = list[k];
			}
				size++;
			}else {
				System.out.println("index" + index + " is out of range!");
			}
		}
	
	@Override
	public void addFirst(E s) {
		addFirst(s, 0);
	}
		
	// remove element from the end of the list
	public void removeLast() {
		if (!isEmpty()) {
			size--;
			Object temp = list[size];
			list[size] = null;
			if(size !=0 && capacity/size >=4 ) resize(this.capacity/2);
			System.out.println(temp + " removed!");
		}else {
			System.out.println("list is empty");
			
		}
	}
	
	 // public void removeDuplication()
	public void removeFirst(E key) {
		int index = compareTo(key);
		if(index != 1) {
			for (int k = index +1; k <= size ; k++) {
				list [k-1] = list[k];
			}
			size--;
			if(size != 0 && capacity/size >=4) resize(this.capacity/2);
			System.out.println(key + " removed!");
		}else {
			System.out.println(key + " is not in the list");
		}
	}
	
	@Override
	public void removeFirst() {
		removeFirst(getElement(0));
	}
	
	// linear search
	private int compareTo(E key) {
		for(int i = 0 ; i < size ; i++) {
			if(list[i].equals(key)) return i;
		}
		return -1;
	}
	
	@Override
	public boolean search(E key) {
		return compareTo(key) != -1;
	}
	
	// 0(1)
	public E getElement(int index) {
		if(index >= 0 && index < size)
			return ((E) list[index]);
		return null;
	}
	
	private void resize(int capacity) {
		this.capacity = capacity;
		E[] temp = ((E[]) list);
		this.list = new Object[this.capacity];
		for(int i = 0 ; i < size ; i++) {
			list [i] = temp[i];
		}
	}
	
	
	public void print() {
		System.out.print("| ");
		for (int i = 0; i < capacity; i++) {
			System.out.print(list[i] + " | ");
		}
		System.out.println();
	}
	
	
} 
