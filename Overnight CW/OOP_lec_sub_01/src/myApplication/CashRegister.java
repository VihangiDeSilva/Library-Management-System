package myApplication;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {

    // initialize the Scanner
    Scanner sc = new Scanner(System.in);

    String itemDescription;     // declare variables
    int unitsInInventory ;
    double price;
    double total = 0;

    RetailItem item1 = new RetailItem("Jacket        ",12,59.95);   // create Array List to store details of items
    RetailItem item2 = new RetailItem("Designer Jeans",40,34.95);
    RetailItem item3 = new RetailItem("Shirt         ",20,24.95);

    private ArrayList<RetailItem> retailItemsList =new ArrayList<RetailItem>();

    public void show_items(){        // crete method to show details
        System.out.println("\n Select the items which you want to buy " );
        System.out.print("Name Of The Item : ");
        itemDescription = sc.next();

        System.out.print("Amount Of Items : ");
        unitsInInventory = sc.nextInt();
        }

        public double get_total() {       // crete method to calculate total price

            for (RetailItem item : retailItemsList) {
                if (itemDescription.equals("Jacket")) {
                    total = total + (item1.getPrice() * unitsInInventory);
                } else if (itemDescription.equals("Designer Jeans")) {
                    total = total + (item2.getPrice() * unitsInInventory);
                } else
                    total = total + (item3.getPrice() * unitsInInventory);
            }
                return total;
            }

    public void purchase_iteam(){        // create method to purchase items
        retailItemsList.add(item1);
        retailItemsList.add(item2);
        retailItemsList.add(item3);

        boolean go = true;
        while(go){

        System.out.print("\nDo you want to Re-select the items ? (0 - No / 1 - Yes) : ");   // asking from user wants to re select items

        int goValue = sc.nextInt();

        if (goValue == 0) {
            go = false;

        } else if (goValue == 1) {
            go = true;
            System.out.println("\n Select the items which you want to buy " ); // to display re select list
            System.out.print("Name Of The Item : ");
            itemDescription = sc.next();
            System.out.print("Amount Of Items : ");
            unitsInInventory = sc.nextInt();
        }
        }
    }
    double payment = 0;

    public void receive_Payment(){    // create method to receive payments
        System.out.print("Input Payments(LKR) :");
        payment = sc.nextDouble();
        }

    public double give_Change(){    // create method to give changes
        double change = 0;
        change = payment - total;
        return (double) change;
    }

    public void clear(){    // create method to clear details
        retailItemsList.clear();
    }

}
