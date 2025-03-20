package crudNoDb;

import campoMinado.customExeptions.InvalidInputExeption;
import campoMinado.customExeptions.OutOFRangeExeption;
import crudNoDb.dataBase.DataBase;
import crudNoDb.dataBase.FileDataBase;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase db = new DataBase();
        FileDataBase file = new FileDataBase();
        file.readAndAddOnDB();
        while (true) {
            System.out.println("========================");
            System.out.println("      Fake Data Base");
            System.out.println("========================");
            System.out.println("(1)add product");
            System.out.println("(2)delete product");
            System.out.println("(3)update product");
            System.out.println("(4)show products");
            System.out.println("(5)exit");
            System.out.println("========================");
            int userInput = checkInputInt(true, 1, 5);
            clearConsole();
            switch (userInput) {
                case 1:
                    System.out.println("========================");
                    System.out.println("product name:");
                    String nameInput = scan.nextLine();
                    System.out.println("product brand:");
                    String brandInput = scan.nextLine();
                    System.out.println("product price:");
                    double priceInput = checkInputDouble();
                    clearConsole();
                    System.out.println("========================");
                    db.addProduct(nameInput, brandInput, priceInput);
                    System.out.println("========================");
                    break;
                case 2:
                    System.out.println("========================");
                    System.out.println("product id:");
                    int idInput = checkInputInt(false, 0, 0);
                    clearConsole();
                    System.out.println("========================");
                    db.deleteProduct(idInput);
                    System.out.println("========================");
                    break;
                case 3:
                    System.out.println("========================");
                    System.out.println("product id:");
                    idInput = checkInputInt(false, 0, 0);
                    System.out.println("product name:");
                    nameInput = scan.nextLine();
                    System.out.println("product brand:");
                    brandInput = scan.nextLine();
                    System.out.println("product price:");
                    priceInput = checkInputDouble();
                    clearConsole();
                    System.out.println("========================");
                    db.upadateProduct(idInput, nameInput, brandInput, priceInput);
                    System.out.println("========================");
                    break;
                case 4:
                    System.out.println("========================");
                    System.out.println("(1)show all products");
                    System.out.println("(2)show by name");
                    System.out.println("(3)show by brand");
                    System.out.println("(4)show by price");
                    System.out.println("========================");
                    userInput = checkInputInt(true, 1, 4);
                    switch (userInput) {
                        case 1:
                            clearConsole();
                            db.printAllProducts();
                            break;
                        case 2:
                            clearConsole();
                            db.printbyName();
                            break;
                        case 3:
                            clearConsole();
                            db.printByBrand();
                            break;
                        case 4:
                            clearConsole();
                            db.printBtPrice();
                            break;
                    }
            }
            if (userInput == 5) {
                break;
            }
        }
        file.save();
    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static double checkInputDouble() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                System.out.println("invalid input");
            }

        }

    }

    public static int checkInputInt(boolean range, int min, int max) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                int number = Integer.parseInt(scan.nextLine());
                if (range && (number < min || number > max)) {
                    throw new OutOFRangeExeption();
                }
                return number;
            } catch (OutOFRangeExeption e) {
                System.out.println("out of options");
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }

    }

}
