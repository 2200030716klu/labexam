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



      session.save(dept1);

      
      
      String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE id = ?3";
      Query query = session.createQuery(hql);

      
      query.setParameter(1, "Updated Department Name");
      query.setParameter(2, "Updated Location");
      query.setParameter(3, 1); 

      int rowsAffected = query.executeUpdate();
      System.out.println("Rows updated: " + rowsAffected);

      
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
