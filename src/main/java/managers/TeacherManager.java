package managers;

import java.util.List;

import entities.Student;
import entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TeacherManager {
	private static EntityManager manager;
	private static EntityManagerFactory factory;
	
	public TeacherManager() {
		connect();
	}

	private static void connect() {
	 factory = Persistence.createEntityManagerFactory("StudentUnit");
	 manager = factory.createEntityManager();
	 manager.getTransaction().begin();
	}
	
	public void commitTransaction() {
	 manager.getTransaction().commit();
	}
	
	public  void closeConnection() {
	 manager.close();
	 factory.close();
	}
	
	public void addTeacher(Teacher teacher) {
     	 manager.persist(teacher);
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
