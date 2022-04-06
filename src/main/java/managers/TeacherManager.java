package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Student;
import entities.Teacher;

public class TeacherManager {
	private static EntityManager manager;
	private static EntityManagerFactory factory;
	
	public TeacherManager() {
		connect();
	}

	private static void connect() {
	 factory = Persistence.createEntityManagerFactory("StudentUnit");
	 manager = factory.createEntityManager();
	}
	
	public void commitTransaction() {
		manager.getTransaction().commit();
	}
	
	public void beginTransaction() {
		manager.getTransaction().begin();
	}
	public  void closeConnection() {
	 manager.close();
	 factory.close();
	}
	
	public void addTeacher(Teacher teacher) {
     	 manager.persist(teacher);
	}
	
	public void addStudents(Student s) {
		manager.persist(s);
	}
	
	public  void updateTeacher(Teacher teacher) {
	 manager.merge(teacher);
	}
	
	public  void remove(String id) {
		Teacher t = manager.getReference(Teacher.class, id);
		manager.remove(t);
	}

	public  Teacher getTeacher(int id) {
		Teacher foundTeacher = manager.find(Teacher.class, id);
		return foundTeacher;
	}
	
	
}
