package managers;

import entities.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LaptopManager {
	private static EntityManager manager;
	private static EntityManagerFactory factory;
	
	public LaptopManager() {
		connect();
	}

	private  void connect() {
	 factory = Persistence.createEntityManagerFactory("StudentUnit");
	 manager = factory.createEntityManager();
	 manager.getTransaction().begin();
	}
	
	public  void closeConnectionAndCommitTransaction() {
	 manager.getTransaction().commit();
	 manager.close();
	 factory.close();
	}
	
	public  void addLaptop(Laptop l) {
		if (l == null)
			throw new NullPointerException("laptop is null");
		manager.persist(l);
	}
	
	public  void updateLaptop(Laptop laptop) {
	 manager.merge(laptop);
	}

	public  Laptop getLaptop(String id) {
		Laptop foundLaptop = manager.find(Laptop.class, id);
		return foundLaptop;
	}

	public  void removeLaptop(String id) {
		Laptop s = manager.getReference(Laptop.class, id);
		manager.remove(s);
	}
}
