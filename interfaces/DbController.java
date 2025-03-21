package crudNoDb.interfaces;

import crudNoDb.models.Status;

public interface DbController {
    public abstract Status addProduct(String name, String brand, double price);
    public abstract Status deleteProduct(int id);
    public abstract Status upadateProduct(int id, String name, String brand, double price);
    public abstract void printAllProducts();
    public abstract void printByName();
    public abstract void printByPrice();
    public abstract void printByBrand();
    public abstract void createFile();
    public abstract void saveOnFile();
    public abstract void getFromFile();

}
