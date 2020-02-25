package l4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService {
    private ProductRepository productRepository;

    @SuppressWarnings("unused")
    @Autowired
    void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    List<Product> getAllProducts(Sort sort) {
        return productRepository.findAll(sort);
    }

    Product getCheapestProduct() {
        return productRepository.findFirstByOrderByPrice();
    }

    Product getMostExpensiveProduct() {
        return productRepository.findFirstByOrderByPriceDesc();
    }
}
