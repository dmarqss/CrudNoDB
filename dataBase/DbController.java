package crudNoDb.dataBase;

import crudNoDb.models.Status;

public interface DbController {
    public abstract Status addProduct(String name, String brand, double price);
    public abstract Status deleteProduct(int id);
    public abstract Status upadateProduct(int id, String name, String brand, double price);
    public abstract void printAllProducts();
    public abstract void printbyName();
    public abstract void printBtPrice();
    public abstract void printByBrand();
}
