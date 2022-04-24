package pl.ms.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 2.5, Category.FOOD_PRODUCT));
        products.add(new Product("kawa", 17, Category.FOOD_PRODUCT));
        products.add(new Product("pralka", 1700, Category.HOUSEHOLD_ARTICLE));
    }

    public List<Product> filterByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().getPlName().equals(category))
                .collect(Collectors.toList());

    }
    public double sumProducts(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void add(Product product) {
        products.add(product);
    }
}
