package inclass.example.genericLists;

public class MyLinkedList<E> implements MyList<E>{

	MyNode<E> first;
	MyNode<E> last;
	int size;
	
	public E getFirstElement() {
		return (E) first.element;
	}
	
	public E getLastElement() {
		return (E) last.element;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void addFirst (E s) {
		MyNode<E> newNode = new MyNode<E>(s);
		if(isEmpty()) {
			last = newNode;
		}else {
			newNode.next = first;
		}
		first = newNode;
		size++;
	}
	
	public void addLast(E s) {
		MyNode<E> newNode = new MyNode<E>(s);
		if(isEmpty()) {
			first = newNode;
		}else {
			newNode.next = first;
		}
		last = newNode;
		size++;
	}
	
	public void removeFirst() {
		if(!isEmpty()) {
			E temp = (E)first.element;
			if(first==last) {// only element
				first = last = null;
			}else {
				first = first.next;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is empty!");
		}
	}
	
	public void removeLast() {
		if(!isEmpty()) {
			E temp = (E) last.element;
			if(last==first) {
				first = last = null;
			}else {
				MyNode<E> prev = first;
				while(prev.next != last) {
					prev = prev.next;
				}
				prev.next = null;
				last = prev;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is empty!");
		}
	}
	
	public boolean search(E key) {
		MyNode<E> pointer = first;
		while(pointer != null && !pointer.element.equals(key)) {
			pointer = pointer.next;
		}
		return pointer != null;
	}
	
	public void remove(E key) {
		if(search(key)) {
			MyNode<E> prev = first;
			MyNode<E> curr = first;
			while(curr != null && !curr.element.equals(key)) {
				prev = curr;
				curr = curr.next;
			}
			if(curr == first) removeFirst();
			else if (curr == last) removeLast();
			else {
				prev.next = curr.next;
				size--;
				System.out.println(key + " is removed!");
			}
			
			
		}else {
			System.out.println(key + " is not in the list!");
		}
	}
	
	
	public void print() {
		MyNode<E> pointer = first;
		if(!isEmpty()) {
			System.out.print("| ");
			while(pointer!=null) {
				System.out.print(pointer.element + " | ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
}
	
class MyNode<E> {
	E element;
	MyNode<E> next;
		
	MyNode(E element){
		this.element = element;
	}
}
