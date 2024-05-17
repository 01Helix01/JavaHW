import java.util.*;

//write your code here

/* Analysis:
 * Implement a cloneable interface for class Student
 * Create two String variables in class student: RollNo and Name
 * Create a parameterized constructor (no default)
 * Use getters to return private data (getRollNo, getName_
 */

/* Design:
 * Created class Student and it's constructor
 * Created getters
 * Encountered error in line 60
 * Implemented a catch for exceptions
 */


class Student implements Cloneable
{
	private String RollNo;
	private String Name;
	
	
	// Constructor
	public Student (String roll, String name)
	{
		RollNo = roll;
		Name = name;
	}
	
	// Getters
	public String getRollNo()
	{
		return RollNo;
	}
	
	public String getName()
	{
		return Name;
	}
	
	
	// Catch exception
	@Override
    public Object clone() throws CloneNotSupportedException
	{
        return new Student(RollNo, Name);
    }
}

class DriverMain
{
    public static void main (String[] args){    
        try{  
            Scanner scanner = new Scanner(System.in);
            String roll = scanner.nextLine();
            String name = scanner.nextLine();
            Student s1=new Student(roll,name);  
            Student s2=(Student)s1.clone();  
            System.out.println(s2.getRollNo());
            System.out.print(s2.getName());

        }catch(CloneNotSupportedException c){}  

    }  
}