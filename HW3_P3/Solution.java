import java.util.*;
import java.lang.*;
import java.io.*;
// all the classes in this Solution.java file have to be default visibilty. 
// Do NOT change the visibilty to public.
// DO not change anything in the Person class Please.

class Person{
	private String name;
	public Person(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " name is " + this.name;
	}
}

// Please write your code here

// Student class
class Student extends Person{
	private int year;
	private String name;
	
	Student (String name,int year)
    {
        super (name);
        
        // Check to make sure status is valid
        if(year >= 1 && year <= 4)
        {
            this.name = name;
            this.year = year;
        }
        else
        {
            System.out.println("Invalid Year");
            this.year = 0;
        }
    }
	
	// Get the year name from the year number
	private String getYearName()
	{
		String yearName = "";
		switch (year)
		{
			case 1:
				yearName = "FRESHMAN";
				break;
			case 2:
				yearName = "SOPHOMORE";
				break;
			case 3:
				yearName = "JUNIOR";
				break;
			case 4:
				yearName = "SENIOR";
				break;
		}
		return yearName;
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getName() + " name is " + this.name + " and status is " + getYearName();
	}
}

// Employee class
class Employee extends Person{
	private int salary;
	private String name;
	
	Employee(String name, int salary)
	{
		super (name);
		
		if (salary > 0)
		{
			this.name = name;
			this.salary = salary;
		}
		else
		{
			System.out.println("Invalid Salary");
            this.salary = 0;
		}
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getName() + " name is " + this.name + " and salary is " + this.salary;
	}
}

// Faculty class
class Faculty extends Employee{
	private int rank;
	private int salary;
	private String name;
	
	Faculty(String name, int salary, int rank)
	{
		super (name, salary);
		
		if (rank > 0)
		{
			this.name = name;
			this.rank = rank;
			this.salary = salary;
		}
		else
		{
			System.out.println("Invalid Rank");
            this.rank = 0;
		}
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getName() + " name is " + this.name + " and salary is " + this.salary + " and rank is " + this.rank;
	}
}

// Staff class
class Staff extends Employee{
	private String title;
	private int salary;
	private String name;
	
	Staff(String name, int salary, String title)
	{
		super (name, salary);
		this.name = name;
		this.salary = salary;
		this.title = title;
	}
	
	@Override
	public String toString()
	{
		return this.getClass().getName() + " name is " + this.name + " and salary is " + this.salary + " and title is " + this.title;
	}
}
