import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

//Your program will be evaluated by this main method and several test cases.

class DriverMain{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		input.close();
		int[] arr = Arrays.stream(str.substring(0, str.length()).split("\\s"))
				.map(String::trim).mapToInt(Integer::parseInt).toArray();		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(list);
		System.out.println(ProblemSolution.removeDuplicate(list));			
	}
}