package com.klef.jfsd.exam.hibernate_hql_labexam;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
  public static void main(String[] args) {
	  
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    Session session = factory.openSession();

    
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

          
      
      Department dept1 = new Department();
      dept1.setName("Computer Science");
      dept1.setLocation("Building A");
      dept1.setHodName("Dr. Alice");

//      Department dept2 = new Department();
//      dept2.setName("Mechanical Engineering");
//      dept2.setLocation("Building B");
//      dept2.setHodName("Dr. Bob");
//
//      Department dept3 = new Department();
//      dept3.setName("Electrical Engineering");
//      dept3.setLocation("Building C");
//      dept3.setHodName("Dr. Charlie");

      session.save(dept1);
//      session.save(dept2);
//      session.save(dept3);
      
      
      String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE id = ?3";
      Query query = session.createQuery(hql);

      // Set positional parameters
      query.setParameter(1, "Updated Department Name");
      query.setParameter(2, "Updated Location");
      query.setParameter(3, 1); // Example: Update department with ID 1

      int rowsAffected = query.executeUpdate();
      System.out.println("Rows updated: " + rowsAffected);

      // Commit the transaction for update
      session.getTransaction().commit();

    
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
      factory.close();
    }
    
    
  }
}
