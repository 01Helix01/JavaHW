package inclass.example.genericLists;

public class TestList {
	
	public static void main(String[] args) {
		

//		MyArrayList<String> list = new MyArrayList<>();
//		System.out.println(list.getSize());
//		list.print();
//		list.addLast("a");
//		list.addLast("b");
//		list.print();
//		list.addFirst("c", list.getSize());
//		list.print();
//		list.addFirst("d",0);
//		list.print();
//		String s = (String) list.getElement(0);
//		System.out.println(s.equals("d"));
		
		
		
		
		
		
		
//		MyLinkedList<String> list = new MyLinkedList<>();
//		list.addFirst("a");
//		list.addFirst("b");
//		list.print();
//		list.removeFirst();
//		list.print();
//		list.addLast("c");
//		list.addLast("d");
//		list.print();
//		list.removeLast();
//		list.print();
		
		
		
		
		MyStack<String> stack = new MyStack<>();
		System.out.println(stack.isEmpty());
		stack.print();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.print();
		System.out.println(stack.search("b"));
		System.out.println(stack.peek());
		stack.pop();
		stack.print();
		stack.pop();
		stack.print();
		stack.pop();
		stack.print();
		
		MyQueue<String> queue = new MyQueue<>();
		System.out.println(queue.isEmpty());
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
	}
	
}
