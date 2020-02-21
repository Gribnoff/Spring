package l3;

import org.hibernate.Session;

public class ProductRepository {
    void showProductBuyers(Session session, int id) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product + " was bought by:");
            for (Customer buyer : product.getBuyers()) {
                System.out.println("\t" + buyer);
            }
            session.getTransaction().commit();
    }

    void deleteProduct(Session session, int id) {
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null)
            session.delete(product);
        session.getTransaction().commit();
    }
}
