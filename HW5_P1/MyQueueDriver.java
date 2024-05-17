import java.util.*;
import java.lang.*;
import java.io.*;

public class MyQueueDriver {

	public static void main(String[] args){
		MyQueue q = new MyQueue();
		Scanner input = new Scanner(System.in);
		int which = input.nextInt(); //which test case
		int quantity = 0; // number of elements to add in the queue
		if(which != 1)	quantity = input.nextInt();
		String[] elements = new String[quantity];
		for(int i = 0; i < quantity; i++)
			elements[i] = input.next();		
		switch (which) {
		case 1 : // test empty queue
			System.out.println(q.toString());
			break;
		case 2 : // test insert method
			for(String s : elements)
				q.insert(s);
			System.out.println(q.toString());				
			break;	
		case 3 : // test remove method
			for(String s : elements)
				q.insert(s);
			q.remove();
			System.out.println(q.toString());
			break;
		}
	}
}

