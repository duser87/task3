package ru.innopolis;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add( new Product(1, "", 10L, 20L));
        products.add( new Product(2, "", 20L, 30L));
        products.add( new Product(3, "", 30L, 40L));
        products.add( new Product(4, "", 40L, 50L));
        products.add( new Product(5, "", 50L, 60L));

        for(Product i: products){

            System.out.println(i.toString());

        }

    }
}