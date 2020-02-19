package l2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/add_product")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @RequestMapping("/adding_product")
    public String showAddedProduct(Model model, @ModelAttribute("product") Product product) {
        productService.addProduct(product.getId(), product.getTitle(), product.getCost());
        return "added-product";
    }

    @RequestMapping("/all_products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "all-products";
    }
}
