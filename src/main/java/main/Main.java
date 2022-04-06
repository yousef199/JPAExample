package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Laptop;
import entities.Student;
import entities.Subject;
import entities.Teacher;
import managers.LaptopManager;
import managers.StudentsManager;
import managers.SubjectManager;
import managers.TeacherManager;

public class Main {
	static StudentsManager studentsManager;
	static TeacherManager teacherManager;

	
	public static void main(String[] args) throws Exception{
		teacherManager = new TeacherManager();
		studentsManager = new StudentsManager();
		String imagePath = "C:\\Users\\yqadous\\Pictures\\wallpaperflare.com_wallpaper (1).jpg";

		Student s1 = new Student("11123" , "yousef" , 14);
		Student s2 = new Student("11124" , "omar" , 17 );
		Student s3 = new Student("11125" , "loai" , 17 );
		Subject math = new Subject(1 , "Math" , null);
		Subject history = new Subject(2 , "History" , null);

		s1.getSubjects().add(history);
		s2.getSubjects().add(history);
		s3.getSubjects().add(history);
		s3.getSubjects().add(math);
		s3.getSubjects().add(math);
		
		studentsManager.beginTransaction();
		studentsManager.addStudent(s3);
		studentsManager.addStudent(s2);
		studentsManager.addStudent(s1);
		studentsManager.commitTransaction();

		teacherManager.closeConnection();
		studentsManager.closeConnection();
	}
	
	public static void writeImageToNewFile(Student s) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yqadous\\Pictures\\newImage1.jpg");
		fileOutputStream.write(s.getImage());
		fileOutputStream.close();
	}

}
