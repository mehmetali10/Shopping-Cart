package models;

public class Item {
    //fields
    private String name;
    private double price;


    //constructors
    public Item(String name, double price) {
        if(name.equals(null) || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        } 
        if(price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }


    //getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //setters
    public void setName(String name) {
        if(name.equals(null) || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.price = price;
    }

    //equals
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item)obj;
        return this.name.equals(item.name) && this.price == item.price;
    }

    //toString
    @Override
    public String toString() {
        return name + ": $" + price + " " + "\t";
    }
    
}
