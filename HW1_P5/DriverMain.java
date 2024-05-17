import java.util.*;

//Your program will be evaluated by this DriverMain class and several test cases.

public class DriverMain {
    public static void main(String[] args) {
    	String str1;
    	String str2;
    	
        Scanner input = new Scanner(System.in);
        
        str1 = input.nextLine();
        str2 = input.nextLine();
        
        if (str1.indexOf(str2) != -1)
        {
            System.out.printf("s2 is a substring of s1");
        }
        
        else
        {
            System.out.printf("s2 is not a substring of s1");
        }
    }
}