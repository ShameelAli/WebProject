package dao;

import model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Dao  {

    @Autowired
    public DataSource dataSource;
    public Dao(DataSource dataSource){
        System.out.println(dataSource);
        System.out.println("datasourse");
        this.dataSource=dataSource;
    }

    @Autowired
    private SessionFactory sessionFactory;


    public void insert(Customer customer) {
        System.out.println(sessionFactory+"  sf");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
    }
}
