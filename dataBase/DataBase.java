package crudNoDb.dataBase;

import crudNoDb.models.Products;
import crudNoDb.models.Status;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataBase implements DbController {
    protected static List<Products> db = new ArrayList<>();

    @Override
    public Status addProduct(String name, String brand, double price) {
        int id = 0;
        try {
            if (!db.isEmpty()) {
                id = db.getLast().getId() + 1;
            }
            db.add(new Products(id, name, price, brand));
            return new Status("added success");
        } catch (Exception e) {
            return new Status("error");
        }
    }

    @Override
    public Status deleteProduct(int id) {
        boolean check = db.removeIf(p -> p.getId() == id);
        if (check) {
            return new Status("deleted successfully");
        } else {
            return new Status("id not found");
        }
    }

    @Override
    public Status upadateProduct(int id, String name, String brand, double price) {
        for (Products p : db) {
            if (p.getId() == id) {
                p.setBrand(brand);
                p.setName(name);
                p.setPrice(price);
                return new Status("updated successfully");
            }
        }
        return new Status("id not found");
    }

    @Override
    public void printAllProducts() {
        db.forEach(p -> System.out.println(p.toString()));
    }

    @Override
    public void printbyName() {
        db.stream().sorted(Comparator.comparing(Products::getName)).forEach(p -> System.out.println(p.toString()));

    }

    @Override
    public void printBtPrice() {
        db.stream().sorted(Comparator.comparing(Products::getPrice)).forEach(p -> System.out.println(p.toString()));
    }

    @Override
    public void printByBrand() {
        db.stream().sorted(Comparator.comparing(Products::getBrand)).forEach(p -> System.out.println(p.toString()));
    }
}
