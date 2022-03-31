package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private String studentID;
	private String name;
	private int age;

	@OneToOne
	public Laptop laptop;

	@ManyToOne
	private Teacher teacher;
	
	@ManyToMany
	private List<Subject> subjects = new ArrayList<>();

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student(String studentID, String name, int age, Laptop laptop) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.age = age;
		this.laptop = laptop;
	}
	
	public Student(String studentID, String name, int age) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.age = age;
	}

	public Student() {
		
	}
	public Laptop getLabtop() {
		return laptop;
	}
	public void setLabtop(Laptop labtop) {
		this.laptop = labtop;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", age=" + age + "]";
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
