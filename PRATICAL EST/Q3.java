class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}
class Electronic extends Product {
    int warranty;  
    Electronic(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }
    @Override
    public void displayDetails() {
        System.out.println("Electronic Item: " + name);
        System.out.println("Price:" + price);
        System.out.println("Warranty: " + warranty + " years");
    }
}
class Clothing extends Product {
    String size;
    String material;
    Clothing(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }
    @Override
    public void displayDetails() {
        System.out.println("Clothing Item: " + name);
        System.out.println("Price:" + price);
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}
public class Q3 {
    public static void main(String[] args) {
        Product p1=new Product("Generic Product", 299);
        Product p2=new Electronic("Laptop", 55000, 2);
        Product p3=new Clothing("T-Shirt", 499, "L", "Cotton");
        p1.displayDetails();
        p2.displayDetails();
        p3.displayDetails();
    }
}
