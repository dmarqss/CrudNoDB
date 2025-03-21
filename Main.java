package crudNoDb;

import crudNoDb.models.DataBase;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase dbList = new DataBase();
        dbList.getFromFile();
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
            int userInput = checkInputInt();
            if(!isOnRange(1,5,userInput)){
                clearConsole();
                continue;
            }
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
                    dbList.addProduct(nameInput, brandInput, priceInput);
                    System.out.println("========================");
                    break;
                case 2:
                    System.out.println("========================");
                    System.out.println("product id:");
                    int idInput = checkInputInt();
                    clearConsole();
                    System.out.println("========================");
                    dbList.deleteProduct(idInput);
                    System.out.println("========================");
                    break;
                case 3:
                    System.out.println("========================");
                    System.out.println("product id:");
                    idInput = checkInputInt();
                    System.out.println("product name:");
                    nameInput = scan.nextLine();
                    System.out.println("product brand:");
                    brandInput = scan.nextLine();
                    System.out.println("product price:");
                    priceInput = checkInputDouble();
                    clearConsole();
                    System.out.println("========================");
                    dbList.upadateProduct(idInput, nameInput, brandInput, priceInput);
                    System.out.println("========================");
                    break;
                case 4:
                    System.out.println("========================");
                    System.out.println("(1)show all products");
                    System.out.println("(2)show by name");
                    System.out.println("(3)show by brand");
                    System.out.println("(4)show by price");
                    System.out.println("========================");
                    userInput = checkInputInt();
                    if(!isOnRange(1,4,userInput)){
                        clearConsole();
                        continue;
                    }
                    switch (userInput) {
                        case 1:
                            clearConsole();
                            dbList.printAllProducts();
                            break;
                        case 2:
                            clearConsole();
                            dbList.printByName();
                            break;
                        case 3:
                            clearConsole();
                            dbList.printByBrand();
                            break;
                        case 4:
                            clearConsole();
                            dbList.printByPrice();
                            break;
                    }
            }
            if (userInput == 5) {
                break;
            }
        }
        dbList.saveOnFile();
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

    public static int checkInputInt() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }
    }

    public static boolean isOnRange(int min, int max, int number){
        return number <= max && number >= min;
    }
}
