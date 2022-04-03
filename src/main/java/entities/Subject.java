package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	int id;
	String name;
	@ManyToMany(mappedBy = "subjects")
	List<Student> students = new ArrayList<>();

	public Subject(int id, String name, List<Student> students) {
		this.id = id;
		this.name = name;
		if(!(students == null))
		students.forEach(s -> this.students.add(s));
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	
}
