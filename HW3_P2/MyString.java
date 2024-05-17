import java.util.*;
import java.lang.*;
import java.io.*;
//toChars() method is already implemented, so please do not change it

/* Analysis:
 * In this program, we will implement our own version of the String class
 * We will have to recreate several methods that belong to the String class
 */

/* Design
 * For length() simply return length of the array
 * For charAt() make sure char is in bounds, then return it
 * For substring(), use the given bounds to copy over a section of the original string into a new one
 * For equals() first make sure the two have the same length so we don't run into any errors (and because it saves time)
 * then compare each char in the original string and the given one
 * For toLowerCase() add 32 to any char that is uppercase
 * For valueOf(int i) convert the integer into data of type MyString
 */



class MyString {

	private char[] chars;

	public MyString(char[] chars) {
		this.chars = chars;

	}
    
    public char[] toChars() { //Do not change this method
        return chars;
    }
    
	public int length() {
		return chars.length;
	}

	public char charAt(int index) {
		// Make sure we're looking at a char in the string, then return that value
		if (index <= length())
		{
			return chars[index];
		}
		// Char was not in string, return an error
		else
		{
			System.out.println("Index out of bound");
			return ' ';
		}
    }

	public MyString substring(int begin, int end) {
		// Create substring based off given bounds
		char sub[] = new char[end - begin];
		
		int j = 0;
		
		// Go through the original string and copy it over to the new substring
		for (int i = begin; i < end; i++)
		{
			sub[j] = chars[i];
			++j;
		}
		
		// return substring
		return new MyString(sub);
	}

	public boolean equals(MyString s){
		// Make sure length is the same, if not return false.
		if (s.length() != length())
		{
			return false;
		}
		// Compare every character in both strings, if different return false.
		else
		{
			for (int i = 0; i < length (); i++)
			{
				if (s.chars[i] != chars[i])
				{
					return false;
				}
			}
		}

		// If string passed both tests return true
		return true;
	}

	public MyString toLowerCase() {
		// Make a new string
		MyString lowerString = new MyString(chars);
		
		// For each uppercase letter in the string, add 32 to make it uppercase
		for (int i = 0; i < length(); i++)
		{
			if (chars[i] >= 'A' && chars[i] <= 'Z')
			{
				chars[i] += 32;
			}
		}
		
		// Return our new string
		return lowerString;
	}

    //convert an int type to MyString type
	public static MyString valueOf(int i) {
		char value[] = new char [100];
		
		int counter = 0;
		int num = 0;
		char c;
		
		while (i > 0)
		{
			num = i % 10;
			c = (char)('0' + num);
			value[counter] = c;
			i = i/10;
			counter++;
		}
		
		char list[] = new char[counter];
		int index = 0;
		
		for (int j = counter-1; j >= 0; j--)
		{
			list[index] = value[j];
			index++;
		}
		
		return new MyString(list);
	}

	

}
