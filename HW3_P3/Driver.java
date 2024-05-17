/* Method:
 * In this assignment, we must make 4 new classes:
 * Student, Employee, Faculty, Staff
 * Student and Employee are subclasses of Person
 * Faculty and Staff are subclasses of Employee
*/

/* Design:
 * Created each class with the respective extensions
 * Student, Salary, and Rank all have checks to make sure they are valid
 * Override the toString method to display information
*/


import java.util.*;
public class Driver {

	public static void main(String[] args){
		Person p = null;
		int which;
		String name;
		int status = 0;
		int salary = 0;
		int rank = 0;
		String title = "0";

		Scanner input = new Scanner(System.in);
		which = input.nextInt();
		name = input.next();
		switch (which) {
		case 1 :
			p = new Person(name);
			break;
		case 2 :
			status = input.nextInt();
			p = new Student(name, status);
			break;
		case 3 :
			salary = input.nextInt();
			p = new Employee(name, salary);
			break;
		case 4 :
			salary = input.nextInt();
			rank = input.nextInt();
			p = new Faculty(name, salary, rank);
			break;
		case 5 :
			salary = input.nextInt();
			title = input.next();
			p = new Staff(name, salary, title);
			break;
		}
		System.out.println(p.toString());
	}
}
