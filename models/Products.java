package crudNoDb.models;

import java.util.Objects;

public class Products {
    private int id;
    private String name;
    private double price;
    private String brand;

    public Products(int id, String name, double price, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String toDB() {
        return id + "," + name + "," + price + "," + brand + ",";
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name=" + name +
                        ", price=" + price +
                        ", brand=" + brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
