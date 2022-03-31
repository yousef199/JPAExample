package main;

import java.util.ArrayList;
import java.util.List;

import entities.Laptop;
import entities.Student;
import entities.Teacher;
import managers.LaptopManager;
import managers.StudentsManager;
import managers.TeacherManager;

public class Main {
	static LaptopManager laptopManager;
	static StudentsManager studentsManager;
	static TeacherManager teacherManager;
	
	public static void main(String[] args) {
		laptopManager = new LaptopManager();
		studentsManager = new StudentsManager();
		teacherManager = new TeacherManager();
		List<Student> studentsList = new ArrayList<Student>();
		
		Teacher t = teacherManager.getTeacher(1156);

		studentsList = t.getStudents();
		System.out.println("Students:");
		System.out.println(studentsList.size());
		
		laptopManager.closeConnectionAndCommitTransaction();
		studentsManager.closeConnectionAndCommitTransaction();
		teacherManager.closeConnectionAndCommitTransaction();
	}

}
