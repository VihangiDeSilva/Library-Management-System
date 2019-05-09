package LibraryManagementSystem;


public class Test {
    public static void main(String[] args) {


        Reader obj1 = new Reader(); // create object from Reader class
        obj1.details();

        LibraryManager obj = new WestminsterLibraryManager();   // create object from
        obj.runMenu();
        obj.addItem();

        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Book Name                                     Author Name                               Publisher              Num Of Pages");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");




    }

}