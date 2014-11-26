package la.random.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import la.random.hibernate.dto.Address;
import la.random.hibernate.dto.UserDetails;

public class Main {

	public static void main(String[] args) {
		System.out.println("main()");
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration
				.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		session = factory.openSession();
		session.beginTransaction();
		add2UsersWithOneAddress(session);
		session.close();
		session = factory.openSession();
		getUserInfo(session);
		session.close();

		
	}
	
	private static void getUserInfo(Session session){
		System.out.println("getUserInfo(session)");
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();
		user1 = (UserDetails) session.get(UserDetails.class, 1);
		user2 = (UserDetails) session.get(UserDetails.class, 2);
		System.out.println("The id is : " + user1.getUserId() + " and the user name is: " + user1.getUserName());
		System.out.println("The id is : " + user2.getUserId() + " and the user name is: " + user2.getUserName());

	}

	private static void add2UsersWithOneAddress(Session session) {
		System.out.println("add2UsersWithOneAddress(session)");
		Address address = new Address();

		address.setZipCode("12345");
		address.setStreet("1212 Boogie Av");
		address.setCity("Any Town");
		address.setState("CA");
		
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();
		
		user1.setUserName("Mr. Smith");
		user2.setUserName("Ms. Smith");
		
		user1.setDiscription("Husband to Mrs. Smith");
		user2.setDiscription("Married to Mr. Smith");
		
		user1.setJoinedDate(new Date());
		user2.setJoinedDate(new Date());
		
		user1.setAddress(address);
		user2.setAddress(address); // note: same address
		
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		
	}

}
