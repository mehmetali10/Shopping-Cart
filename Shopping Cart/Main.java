import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Store;
import models.Item;


public class Main{
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            loadProduct("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            manageItems();
        }
        
    }

    
    //loadProduct from file
    public static void loadProduct(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);

        while(scan.hasNextLine()) {
            for(int row=0; row<7; row++) {

                String line = scan.nextLine();
                String[] arr1 = line.split(";");

                for(int column=0; column<arr1.length; column++) {
                    String[] arr2 = arr1[column].split("=");
                    store.setItem(row, column, new Item(arr2[0], Double.parseDouble(arr2[1])));
                }
            }
        }
        scan.close();
    }


    public static void manageItems() {

        Scanner scan = new Scanner(System.in);
        while(true) {
        System.out.println("\n\t******************************JAVA GROCERS******************************\n");
        System.out.println(store);

        System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout \n\td) Exit");
        String option = scan.nextLine();

        switch (option) {
            case "a":   
                        int row = askRow(scan);         //asks user the number of row and returns it
                        int column = askColumn(scan);   //asks user the number of column and returns it

                        if (row == 404 || column == 404) {
                            continue;
                        } else if (row < 0 || row > 6 || column < 0 || column > 2) {
                            continue;
                        }

                        if(cart.add(store.getItem(row, column))) {
                            System.out.println("\n\t" + store.getItem(row, column).getName() + " is already in your shopping cart.");
                        } else {
                            cart.add(store.getItem(row, column));
                        }
                        System.out.println("\n\nSHOPPING CART\n\n" + cart);
                
                break;

            case "b" :  if(cart.isEmpty()) {
                            System.out.println("\tEmpty shopping cart! nothing to see here");
                        } else {
                            System.out.print("Enter the item you'd like to remove: ");
                            String itemName = scan.nextLine();
                            cart.remove(itemName);
                            System.out.println("\n\nSHOPPING CART\n\n" + cart);
                        }
                        
                break;
                
            case "c" :  if(cart.isEmpty()) {
                            continue;
                        } else{
                            System.out.println("\n\nSHOPPING CART\n\n" + cart);
                            System.out.println(cart.checkout());
                        }   
                break;        
                        
            case "d" :  System.out.println("\n\nSHOPPING CART\n\n" + cart);
                        System.exit(0); 
                break;        
            default:    System.out.println("invalid option");
                break;
        }

    }

    }

    public static int askRow(Scanner scan) {
        System.out.print("\nChoose an aisle number between: 1 – 7: ");
        int row = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
        scan.nextLine();
        return row;
    }

    public static int askColumn(Scanner scan) {
        System.out.print("Choose an item number between: 1 - 3: ");
        int column = scan.hasNextInt() ? scan.nextInt() -1 : 404;
        scan.nextLine();
        return column;
    }
}