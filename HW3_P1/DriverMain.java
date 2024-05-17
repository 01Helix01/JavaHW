/* Analysis:
 * In this assignment, we have mostly finished code, as all we need to do is modify the Classroom class
 * Must add a student to the students list using the function addStudent
 * Must return the students list using the function getAllStudents
*/

/* Design:
 * in function addStudent, create a new Student and set name as well as roll number using the pre-made setters
 * in function getAllStudents, simply return the students array, as the return type is Student[]
 * made a small change in line 31 that created an array of Student with a size of 10 in Classroom as I was encountering errors testing
*/


import java.util.*;

//Your program will be evaluated by this DriverMain class and several test cases.

public class DriverMain {
    public static void main(String[] args) {
        String name;
		int rollNo;
		int n = 0;
		Student[] students = new Student[10];
		ClassRoom classRoom = new ClassRoom();
		Scanner input = new Scanner(System.in);
		while(true){
            try{
			    name = input.nextLine();
				rollNo = Integer.parseInt(input.nextLine());
            }catch(Exception e){
                break;
            }
			if(name.equals("")) 
				break;

			classRoom.addStudent(name, rollNo);
			n++;
		}
		students = classRoom.getAllStudents();
		for (int i = 0; i < n; i++) {
			if(students[i]!=null)
			System.out.print(students[i].getRollNo() + " - " + students[i].getName());
			if (i < n - 1)
				System.out.println();
		}
    }
}