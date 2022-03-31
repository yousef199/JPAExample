package managers;

import java.util.List;

import org.hibernate.query.Query;

import entities.Student;
import entities.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentsManager {
	private static EntityManager manager;
	private static EntityManagerFactory factory;

	public StudentsManager() {
		connect();
	}
	
	private void connect() {
	 factory = Persistence.createEntityManagerFactory("StudentUnit");
	 manager = factory.createEntityManager();
	 manager.getTransaction().begin();
	}
	
	public void closeConnectionAndCommitTransaction() {
	 manager.getTransaction().commit();
	 manager.close();
	 factory.close();
	}
	
	public  void addStudent(Student student) {
	 manager.persist(student);
	}
	
	public  void updateStudent(Student student) {
	 manager.merge(student);
	}

	public  Student getStudent(String id) {
		Student foundStudent = manager.find(Student.class, id);
		return foundStudent;
	}
	
	public  void remove(String id) {
		Student s = manager.getReference(Student.class, id);
		manager.remove(s);
	}
	
	public  List<Student> getStudentAgeLessThan(int age){
		String jbql = "Select s From Student s Where s.age <  "+age;
		Query query = (Query) manager.createQuery(jbql);
		List<Student> resultStudents = query.getResultList();
		return  resultStudents;
	}
}
