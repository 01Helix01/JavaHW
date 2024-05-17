import java.util.*;

class Student {
	private String name;
	private int rollNo;
	
	public String getName() {
		return name;
	}

	public	void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
};

//Write your code in the ClassRoom Class

class ClassRoom {

	private int i;
	
	// modified this line to make the array objects of Student class
	private Student[] students = new Student[10];

	public void addStudent(String name, int rollNo) {
		// add student using setters from class Student
		students[i] = new Student();
		students[i].setName(name);
		students[i].setRollNo(rollNo);
		++i;
		return;
	}
	
	public Student[] getAllStudents() {
		// return the sudents array as a Student[] value
		return students;
	}
};
