import java.util.*;

public class MinHeapDriver{

	public static void main(String[] args) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		Scanner input = new Scanner(System.in);
		int which = input.nextInt();
		int quantity = input.nextInt();
		// Add elements to the min heap
		for(int i = 0; i < quantity; i++)
			minHeap.add(input.nextInt());	

		switch (which) {
		case 1 : // test add method
			minHeap.print();
			break;
		case 2 : // test remove method
			System.out.print(minHeap.remove());
			break;
		case 3 : // test heap sort
			// Remove elements from the min heap
			for (int i = 0; i < quantity; i++)
				System.out.print(minHeap.remove() + " ");
			break;
		}
	}


}
