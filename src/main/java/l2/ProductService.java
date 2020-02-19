package l2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void addProduct(int id, String title, float cost) {
        productRepository.addProduct(id, title, cost);
    }

    public void addProduct(String title, float cost) {
        productRepository.addProduct(title, cost);
    }

    public void removeProduct(int id) {
        productRepository.removeProduct(id);
    }


    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }
}
