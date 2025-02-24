import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1500.0));
        products.add(new Product("Smartphone", "Electronics", 800.0));
        products.add(new Product("Table", "Furniture", 200.0));
        products.add(new Product("Chair", "Furniture", 150.0));
        products.add(new Product("Headphones", "Electronics", 250.0));
        products.add(new Product("Sofa", "Furniture", 700.0));
        products.add(new Product("T-shirt", "Clothing", 30.0));
        products.add(new Product("Jeans", "Clothing", 50.0));
        
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + product.get().toString());
        });

        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
