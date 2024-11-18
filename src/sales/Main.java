/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sales;

import java.util.*;
import java.io.*;

/**
 *
 * @author jayia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        customer map
        Map<Integer, Customer> customers = new HashMap<>();

//        products map 
        Map<Integer, Product> products = new HashMap<>();

//        read each record
        String line = "";

        try (BufferedReader r = new BufferedReader(new FileReader("Sales.txt"))) {
            while ((line = r.readLine()) != null) {
                processLine(line, customers, products);
            }
            
            print(customers, products);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Sales.txt file not found.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

//    read each line and update accordingly
    static void processLine(String line, Map<Integer, Customer> customers, Map<Integer, Product> products) {

        try {
            String[] arr = line.split(" ");
            //      customerID, fname, lname, productID, product, price, quantity

            int customerID = Integer.parseInt(arr[0]);
            int productID = Integer.parseInt(arr[3]);
            double total = Double.parseDouble(arr[5]) * Double.parseDouble(arr[6]);
            
//          avoid duplcate customers
            if (!customers.containsKey(customerID)) {
                customers.put(customerID, new Customer(customerID, arr[1], arr[2]));
            }
            customers.get(customerID).updateTotal(total);

//           avoid duplicate products
            if(!products.containsKey(productID)){
                products.put(productID, new Product(productID, arr[4]));
            }
            products.get(productID).updateCount(Integer.parseInt(arr[6]));
            
        } catch (Exception e) {
            System.err.println("Error processing line: " + line);
        }

    }
    
    static void print(Map<Integer, Customer> customers, Map<Integer, Product> products){
        //customer bills
            System.out.println("----Customers----");
            for (Customer c : customers.values()) {
                c.printBill();
            }
            System.out.println("\n");
            
        // products
            System.out.println("----products----");
            for (Product p : products.values()) {
                p.print();
            }
    }

}
