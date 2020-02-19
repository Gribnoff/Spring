package l2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(int id, String title, float cost) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setCost(cost);
        products.add(product);
    }

    public void addProduct(String title, float cost) {
        Product product = new Product();
        product.setId(products.size());
        product.setTitle(title);
        product.setCost(cost);
        products.add(product);
    }

    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }


    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(int id) {
        return products.stream()
                .filter(product -> id == product.getId())
                .findAny()
                .orElse(null);
    }
}
