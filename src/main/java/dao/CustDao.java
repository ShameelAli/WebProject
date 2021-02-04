package dao;

import model.Customer;
import org.hibernate.HibernateException;

public interface CustDao {

    public void insert(Customer customer) throws HibernateException;
}
