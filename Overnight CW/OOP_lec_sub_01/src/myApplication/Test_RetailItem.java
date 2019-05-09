package myApplication;

public class Test_RetailItem {
    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------");
        System.out.println(" Description         Units In Inventory        Price(LKR) ");
        System.out.println("----------------------------------------------------------");

        RetailItem storeItem1 = new RetailItem("  Jacket        ",12,59.95); // create object for RetailItem class
        storeItem1.displayItems(); // calling methods

        RetailItem storeItem2 = new RetailItem("  Designer Jeans",40,34.95); // create object for RetailItem class
        storeItem2.displayItems(); // calling methods

        RetailItem storeItem3 = new RetailItem("  Shirt         ",20,24.95); // create object for RetailItem class
        storeItem3.displayItems(); // calling methods

        CashRegister registry = new CashRegister(); // create object for CashRegister class
        registry.show_items();  // calling methods
        registry.purchase_iteam();
        System.out.println("Total price : " + registry.get_total() + " LKR");
        registry.receive_Payment();
        System.out.println("Balance : " + registry.give_Change() + " LKR");
        registry.clear();




    }
}
