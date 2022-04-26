package pl.ms.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("categories", Category.values());
        model.addAttribute("product", new Product());
        return "form";
    }
    @PostMapping("/zapisz")
    public String addProduct(Product product, Model model) {
        productRepository.add(product);
        model.addAttribute("product", product);
        return "success";
    }
}