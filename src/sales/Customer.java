/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales;

/**
 *
 * @author jayia
 */
public class Customer {
    private String fname;
    private String lname;
    private double total;
    private int id;
    
    public Customer(int id, String fname, String lname){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.total = 0.0;
    }
    
    public void updateTotal(double amount){
        this.total += amount;
    }
    
    public void printBill(){
        System.out.println("=========");
        System.out.println("Name: "+ this.fname + " " + this.lname + "(" + this.id +")");
        System.out.println("Total Bill: $"+ this.total);
    }
}
