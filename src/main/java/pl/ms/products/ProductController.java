package pl.ms.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/lista")
    public String showCategory(@RequestParam("kategoria") String category, Model model) {
        List<Product> filteredProducts = productRepository.filterByCategory(category);
        if (!filteredProducts.isEmpty()) {
            double sum = productRepository.sumProducts(filteredProducts);
            model.addAttribute("products", filteredProducts);
            model.addAttribute("category", category);
            model.addAttribute("sum", sum);
            return "category";
        } else {
            return "redirect:/kategoria?pusta=" + category;
        }
    }
    @GetMapping("/kategoria")
    public String informEmpty(@RequestParam("pusta")String emptyCategory, Model model) {
        model.addAttribute("emptyCategory", emptyCategory);
        return "emptyCategory";
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