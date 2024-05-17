import java.util.*;
import java.lang.*;
import java.io.*;

/*Analysis:
 * For this assignment, we have to finish the myQueue class
 * In order to shift our stacks, we will use two stacks
 */

/*Design:
 * for our insert function, make sure we catch empty or null
 * I used an additional remove function to be able to remove the first in the MyQueueDriver call
 * Pop the data in stack1 and push it into 2 to make our data LIFO rather than FIFO
 */

public class MyQueue{
    private int maxCapacity = 4;
    private Stack<String> stack1;
	private Stack<String> stack2;
    
	private int size;
	
    public MyQueue(){
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
    public int size(){
    	return this.size;
    }
    
    public void insert(String value){
    	if(value == " " || value == null)
    	{
    		return;
    	}
    	else
    		stack1.push(value);
    	size++;
    }
    
    public String remove(){
    	size--;
    	return stack1.remove(0);
    }
    
    public String outputRemove(){
    	size--;
    	return stack1.pop();
    }
    
    private void shiftStacks(){
    	while(!stack1.isEmpty())
    	{
    		stack2.push(stack1.pop());
    	}
    	
    	stack1 = stack2;
    } 
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public boolean isFull(){
    	if(size >= maxCapacity)
    		return true;
    	else
    		return false;
    }
    
    @Override //[QueueSize:Full/Empty:QueueElementsList]
	public String toString(){
		shiftStacks();
		StringBuilder sb = new StringBuilder("[");
		sb.append(this.size()).append(":");
		if(this.isEmpty())
			sb.append("Empty").append(":");
		else if (this.isFull())
			sb.append("Full").append(":");
		while(!isEmpty()){
			sb.append(this.outputRemove());
			if(this.size()!=0) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}   
}
