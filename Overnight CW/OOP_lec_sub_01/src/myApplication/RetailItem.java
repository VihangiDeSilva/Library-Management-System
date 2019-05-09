package myApplication;

public class RetailItem {
    private String itemDescription;     // declare variables
    private int unitsInInventory;
    private double price;

    public RetailItem(String itemDescription, int unitsInInventory, double price) { // creating constructor for declared variables
        this.itemDescription = itemDescription;
        this.unitsInInventory = unitsInInventory;
        this.price = price;
    }

    public String getItemDescription() {        // getter and setter methods
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getUnitsInInventory() {
        return unitsInInventory;
    }

    public void setUnitsInInventory(int unitsInInventory) {
        this.unitsInInventory = unitsInInventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayItems(){         // create method for display items
        System.out.println(itemDescription + "             " + unitsInInventory + "                 " + price );
    }


}
