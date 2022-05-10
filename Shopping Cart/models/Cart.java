package models;

import java.util.ArrayList;

public class Cart {
    //field
    ArrayList<Item> items;

    //constructor
    public Cart() {
        this.items = new ArrayList<Item>();
    }

    //getItem 
    public Item getItems(int index) {
        return items.get(index);
    }
   
    //setItem
    public void setItems(int index, Item item) {
        if(index < 0 || index > items.size()) {
            throw new IllegalArgumentException("index cannot be negative or out of size");
        }
        items.set(index, item);
    }

    //add
    public boolean add(Item item) {
        if(items.contains(item)) {
            return true;
        }
        this.items.add(item);
        return false;
    }

    //remove
    public void remove(String name) {
        if(items.isEmpty()) {
            throw new IllegalStateException("items arraylist is emty");
        }
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).getName().equals(name)) {
                items.remove(i);
            }
        }
    }

    //checkout
    public String checkout() {
        if(items.isEmpty()) {
            throw new IllegalStateException("items arraylist is emty");
        }
        double[] arr = new double[3];

        for(int i=0; i<arr.length; i++) {
            arr[0] += this.items.get(i).getPrice();
        }

        //tax arr[1]. subtotal arr[0].
        arr[1] = arr[0] * 0.13;
        // total = subtotal + tax
        arr[2] = arr[0] + arr[1];

        return "\tRECEIPT\n\n" +
        "\tSubtotal: $" + arr[0] + "\n" +
        "\tTax: $" + String.format("%.2f", arr[1]) + "\n" +
        "\tTotal: $" + String.format("%.2f", arr[2]) + "\n";

    }

    //isempty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    //toString
    @Override
    public String toString() {
        String temp = "";
        for(int i=0; i<items.size(); i++) {
            temp += items.get(i).toString() + "\n";
        }

        return temp;
    }    
}
