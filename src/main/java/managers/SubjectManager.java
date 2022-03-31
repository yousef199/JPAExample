package managers;

import entities.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SubjectManager {

	private static EntityManager manager;
	private static EntityManagerFactory factory;
	
	public SubjectManager() {
		connect();
	}

	private static void connect() {
	 factory = Persistence.createEntityManagerFactory("StudentUnit");
	 manager = factory.createEntityManager();
	 manager.getTransaction().begin();
	}
	
	public static void closeConnectionAndCommitTransaction() {
	 manager.getTransaction().commit();
	 manager.close();
	 factory.close();
	}

	public void addSubject(Subject subject) {
     	 manager.persist(subject);
	}
	
	
	public  void updateSubject(Subject subject) {
	 manager.merge(subject);
	}
	
	public void remove(String id) {
		Subject s = manager.getReference(Subject.class, id);
		manager.remove(s);
	}

	public  Subject getTeacher(int id) {
		Subject foundSubject = manager.find(Subject.class, id);
		return foundSubject;
	}
}
