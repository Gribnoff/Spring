package l4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @SuppressWarnings("unused")
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @SuppressWarnings("unused")
    @RequestMapping("/catalog")
    public List<Product> getProducts(@Param("sort") String sort, @Param("filter") String filter) {
        if (sort == null && filter == null)
            return productService.getAllProducts();

        List<Product> result = new ArrayList<>();
        if (sort != null) {
            if (sort.equals("asc"))
                result = productService.getAllProducts(Sort.by("price").ascending());
            else if (sort.equals("desc"))
                result = productService.getAllProducts(Sort.by("price").descending());
        }

        if (filter != null) {
            switch (filter) {
                case "lowest":
                    result.add(productService.getCheapestProduct());
                    break;
                case "highest":
                    result.add(productService.getMostExpensiveProduct());
                    break;
                case "both":
                    result.add(productService.getCheapestProduct());
                    result.add(productService.getMostExpensiveProduct());
                    break;
            }
        }
        return result;
    }
}
