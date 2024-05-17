
import java.util.Arrays;
import java.util.Scanner;

public class Solution{

    /*
    * My Solution
    */
    public static int getNthFromLast(MyLinkedList list, int n){
        //Write your code here
    	int size = list.getSize();
    	Node head = getHead();
    	int element = getElement();
    	
    	if(n > size) {
    		return -1;
    	} else {
	    	for (int i; i < size - n; i++) {
	    		list.getNext();
	    	}
    	
    	return element;
    }
    
    
//DO NOT CHANGE ----------------------------------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int n = input.nextInt();
        input.close();
        int[] arr = Arrays.stream(str.substring(0, str.length()).split("\\s"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();		
        MyLinkedList list = new MyLinkedList();
        for(int i = 0; i < arr.length; i++){
            list.addLast(arr[i]);
        }
        System.out.println(Solution.getNthFromLast(list, n));
    }
//DO NOT CHANGE ----------------------------------

}
