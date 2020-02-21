package l3;

import org.hibernate.Session;

public class CustomerRepository {
    void showCustomersPurchases(Session session, int id) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            System.out.println(customer + " purchased:");
            for (Product purchase : customer.getPurchases()) {
                System.out.println("\t" + purchase);
            }
            session.getTransaction().commit();
    }

    void deleteCustomer(Session session, int id) {
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        if (customer != null)
            session.delete(customer);
        session.getTransaction().commit();
    }
}
