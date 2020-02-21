package l3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

                Session session = factory.getCurrentSession()) {

            customerRepository.showCustomersPurchases(session, 2);
            productRepository.showProductBuyers(session, 5);
        }
    }
}
