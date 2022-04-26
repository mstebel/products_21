package pl.ms.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
class CategoryController {
    private ProductRepository productRepository;

    public CategoryController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String showCategory(@RequestParam("kategoria") String category, Model model) {
        List<Product> filteredProducts = productRepository.filterByCategory(category);
        double sum = productRepository.sumProductsByCategory(category);
        model.addAttribute("products", filteredProducts);
        model.addAttribute("category", category);
        model.addAttribute("sum", sum);
        return "category";
    }
}
