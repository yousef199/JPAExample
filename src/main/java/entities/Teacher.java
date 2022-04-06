package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Teacher {
	@Id
	private int id;
	private String name;
	private int age;
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<Student>();
	
	public Teacher(){
		
	}
	
	
	public Teacher(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}


	public Teacher(int id, String name, int age, List<Student> students) {
		this.id = id;
		this.name = name;
		this.age = age;
		students.stream().forEach(s -> this.students.add(s));
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
