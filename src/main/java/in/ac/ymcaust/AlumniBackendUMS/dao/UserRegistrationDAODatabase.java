package in.ac.ymcaust.AlumniBackendUMS.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.ac.ymcaust.AlumniBackendUMS.model.Registration;
import in.ac.ymcaust.AlumniBackendUMS.model.UserDetails;

@Repository
@Transactional
public class UserRegistrationDAODatabase implements UserRegistrationDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	public Registration verifyUser(String email) {
		EntityManager manager = getManager();
		Registration reg = (Registration)manager.find(Registration.class, email);
		manager.close();
		return reg;
	}

	public boolean registerUser(Registration registration, UserDetails userDetails) {
		EntityManager manager = getManager();
		EntityTransaction txn = null;
		System.out.println("DAO: Trying to register user");
		try {
			System.out.println("DAO: Getting transaction object.");
			txn =  manager.getTransaction();
			if(!txn.isActive()) {
				System.out.println("DAO: Beginning transaction.");
				txn.begin();
			}
			manager.persist(registration);
			System.out.println("DAO: User registered.");
			manager.persist(userDetails);
			System.out.println("DAO: User Details filled.");
			txn.commit();
			System.out.println("DAO: Transaction commited");
		}catch(Exception e) {
			System.out.println("DAO: Error occured");
			if(txn != null) {
				System.out.println("DAO: Rolling back");
				System.out.println("DAO: Error " + e.toString());
				txn.rollback();
			}
			manager.clear();
			return false;
		}
		return true;
	}
	
	private EntityManager getManager() {
		return factory.createEntityManager();
		
	}

}