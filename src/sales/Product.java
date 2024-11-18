/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales;

/**
 *
 * @author jayia
 */
public class Product {
    private int id;
    private String name;
    private int totalPurchases;
    
    public Product(int id, String name){
        this.id = id;
        this.name = name;
        this.totalPurchases =0;
    }
    
    public void updateCount(int count){
        this.totalPurchases += count;
    }
    
    public void print(){
        System.out.println("=========");
        System.out.println("Name: "+ this.name + " (" + this.id +")");
        System.out.println("Total Purchase: "+ this.totalPurchases);
    }
    
    
}
