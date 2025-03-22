package crudNoDb.models;

import java.util.Comparator;

public class DatabaseDAO extends DataBase {
    public DatabaseDAO() {
        getFromFile();
    }

    public int genId() {
        int id = 0;
        if (!dbList.isEmpty()) {
            id = dbList.stream().toList().getLast().getId() + 1;
        }
        return id;
    }

    public void addProduct(String name, String brand, double price) {
        try {
            dbList.add(new Products(genId(), name, price, brand));
            saveOnFile();
            System.out.println("added success");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void deleteProduct(int id) {
        boolean check = dbList.removeIf(p -> p.getId() == id);
        if (check) {
            saveOnFile();
            System.out.println("deleted successfully");
        } else {
            System.out.println("id not found");
        }
    }

    public void upadateProduct(int id, String name, String brand, double price) {
        for (Products p : dbList) {
            if (p.getId() == id) {
                p.setBrand(brand);
                p.setName(name);
                p.setPrice(price);
                saveOnFile();
                System.out.println("updated successfully");
            }
        }
        System.out.println("id not found");
    }

    public void printAllProducts() {
        dbList.forEach(p -> System.out.println(p.toString()));
    }

    public void printByName() {
        dbList.stream().sorted(Comparator.comparing(Products::getName)).forEach(p -> System.out.println(p.toString()));

    }

    public void printByPrice() {
        dbList.stream().sorted(Comparator.comparing(Products::getPrice)).forEach(p -> System.out.println(p.toString()));
    }

    public void printByBrand() {
        dbList.stream().sorted(Comparator.comparing(Products::getBrand)).forEach(p -> System.out.println(p.toString()));
    }
}
