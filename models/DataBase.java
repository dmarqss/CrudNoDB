package crudNoDb.models;

import crudNoDb.interfaces.DbController;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataBase implements DbController {
    protected static List<Products> dbList = new ArrayList<>();
    private final File file = new File("crudNoDb/files/DB.txt");

    public DataBase() {
        createFile();
    }

    public int genId(){
        int id = 0;
        if (!dbList.isEmpty()) {
            id = dbList.getLast().getId() + 1;
        }
        return id;
    }

    @Override
    public Status addProduct(String name, String brand, double price) {
        try {
            dbList.add(new Products(genId(), name, price, brand));
            return new Status("added success");
        } catch (Exception e) {
            return new Status("error");
        }
    }

    @Override
    public Status deleteProduct(int id) {
        boolean check = dbList.removeIf(p -> p.getId() == id);
        if (check) {
            return new Status("deleted successfully");
        } else {
            return new Status("id not found");
        }
    }

    @Override
    public Status upadateProduct(int id, String name, String brand, double price) {
        for (Products p : dbList) {
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
        dbList.forEach(p -> System.out.println(p.toString()));
    }

    @Override
    public void printByName() {
        dbList.stream().sorted(Comparator.comparing(Products::getName)).forEach(p -> System.out.println(p.toString()));

    }

    @Override
    public void printByPrice() {
        dbList.stream().sorted(Comparator.comparing(Products::getPrice)).forEach(p -> System.out.println(p.toString()));
    }

    @Override
    public void printByBrand() {
        dbList.stream().sorted(Comparator.comparing(Products::getBrand)).forEach(p -> System.out.println(p.toString()));
    }

    @Override
    public void createFile() {
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void saveOnFile() {
        AtomicBoolean append = new AtomicBoolean(false);
        dbList.forEach(p -> {
            try (FileWriter fw = new FileWriter(file, append.get())) {
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(p.toSaveOnFile());
                bw.newLine();
                bw.flush();
                bw.close();
                append.set(true);
            } catch (Exception e) {
                e.getStackTrace();
            }
        });

    }

    @Override
    public void getFromFile() {
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayLine = line.split(",");
                DataBase.dbList.add(new Products((
                        Integer.parseInt(arrayLine[0])),
                        arrayLine[1],
                        Double.parseDouble(arrayLine[2]),
                        arrayLine[3]));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
