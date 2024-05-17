import java.util.*;
import java.lang.*;
import java.io.*;

public class Driver {
    
    public static void main(String[] args){
        String str = null;
		MyString s = null;
		Scanner input = new Scanner(System.in);
		int which = input.nextInt();
		if(which!=6)
			str = input.next();
		switch (which) {
		case 1 : // test length method
			s = new MyString(str.toCharArray());
			System.out.println(s.length());
			break;
		case 2 : // test charAt method
			s = new MyString(str.toCharArray());
			System.out.println(s.charAt(input.nextInt()));				
			break;	
		case 3 : // test substring method
			s = new MyString(str.toCharArray());
			System.out.println(new String(s.substring(input.nextInt(), input.nextInt()).toChars()));
			break;
		case 4 : // test equals method 
			String str2 = input.next();				
			s = new MyString(str.toCharArray());
			MyString s2 = new MyString(str2.toCharArray());
			System.out.println(s.equals(s2));
			break;
		case 5 : // test toLowerCase method  
			s = new MyString(str.toCharArray());
			System.out.println(new String(s.toLowerCase().toChars()));
			break;
		case 6 : // test valueOf method  
			System.out.println(new String(MyString.valueOf(input.nextInt()).toChars()));
			break;
		}
	}
}
