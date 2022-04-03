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
	static LaptopManager laptopManager;
	static StudentsManager studentsManager;
	static TeacherManager teacherManager;
	static SubjectManager subjectManager;

	
	public static void main(String[] args) throws Exception{
		studentsManager = new StudentsManager();
		teacherManager = new TeacherManager();
		String imagePath = "C:\\Users\\yqadous\\Pictures\\wallpaperflare.com_wallpaper (1).jpg";

		PhotoChooser pc = new PhotoChooser(imagePath);
		Laptop l = new Laptop("1" , "Dell");
		Student s1 = new Student("1123" , "yousef" , 14);
		Student s2 = new Student("1124" , "omar" , 17 , l);
		Teacher t = new Teacher(1245 , "yousef" , 20 );
		t.getStudents().add(s2);
		
		studentsManager.remove("1123");
		teacherManager.commitTransaction();

		studentsManager.closeConnection();
		teacherManager.closeConnection();
	}
	
	public static void writeImageToNewFile(Student s) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yqadous\\Pictures\\newImage1.jpg");
		fileOutputStream.write(s.getImage());
		fileOutputStream.close();
	}

}
