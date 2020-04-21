package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
        products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product index : products) {
            if (index != null) {
                System.out.println(index.getName());
            } else {
                System.out.println("null");
            }
        }
        Shop shop = new Shop();
        shop.delete(products, 1);
        System.out.println(System.lineSeparator());
        for (Product index : products) {
            if (index != null) {
                System.out.println(index.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
