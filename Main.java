package crudNoDb;

import crudNoDb.models.DatabaseDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int userInput;
            int idUserInput;
            double priceUserInput;
            String nameUserInput;
            String brandUserInput;
            DatabaseDAO dbDAO = new DatabaseDAO();

            System.out.println("========================");
            System.out.println("      Fake Data Base");
            System.out.println("========================");
            System.out.println("(1)add product");
            System.out.println("(2)delete product");
            System.out.println("(3)update product");
            System.out.println("(4)show products");
            System.out.println("(5)exit");
            System.out.println("========================");

            userInput = checkInputInt();
            if (!isOnRange(1, 5, userInput)) {
                clearConsole();
                continue;
            }
            clearConsole();
            switch (userInput) {
                case 1:
                    System.out.println("========================");
                    System.out.println("product name:");
                    nameUserInput = scan.nextLine();

                    System.out.println("product brand:");
                    brandUserInput = scan.nextLine();

                    System.out.println("product price:");
                    priceUserInput = checkInputDouble();

                    clearConsole();
                    System.out.println("========================");
                    dbDAO.addProduct(nameUserInput, brandUserInput, priceUserInput);
                    System.out.println("========================");
                    break;
                case 2:
                    System.out.println("========================");
                    System.out.println("product id:");
                    idUserInput = checkInputInt();

                    clearConsole();
                    System.out.println("========================");
                    dbDAO.deleteProduct(idUserInput);
                    System.out.println("========================");
                    break;
                case 3:
                    System.out.println("========================");
                    System.out.println("product id:");
                    idUserInput = checkInputInt();

                    System.out.println("product name:");
                    nameUserInput = scan.nextLine();

                    System.out.println("product brand:");
                    brandUserInput = scan.nextLine();

                    System.out.println("product price:");
                    priceUserInput = checkInputDouble();

                    clearConsole();
                    System.out.println("========================");
                    dbDAO.upadateProduct(idUserInput, nameUserInput, brandUserInput, priceUserInput);
                    System.out.println("========================");
                    break;
            }
            if (userInput == 4) {
                System.out.println("========================");
                System.out.println("(1)show all products");
                System.out.println("(2)show by name");
                System.out.println("(3)show by brand");
                System.out.println("(4)show by price");
                System.out.println("========================");

                userInput = checkInputInt();
                if (!isOnRange(1, 4, userInput)) {
                    clearConsole();
                    continue;
                }
                switch (userInput) {
                    case 1:
                        clearConsole();
                        dbDAO.printAllProducts();
                        break;
                    case 2:
                        clearConsole();
                        dbDAO.printByName();
                        break;
                    case 3:
                        clearConsole();
                        dbDAO.printByBrand();
                        break;
                    case 4:
                        clearConsole();
                        dbDAO.printByPrice();
                        break;
                }
            }
            if (userInput == 5) {
                break;
            }
        }
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

    public static boolean isOnRange(int min, int max, int number) {
        return number <= max && number >= min;
    }
}
