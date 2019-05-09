package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        // initialize the Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println(" Welcome To Public Library ");
        System.out.println("------------------------------");

        LibraryItem obj1 = new Reader(); // create object from Reader class
        obj1.details();

        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Book Name                                     Author Name                               Publisher              Num Of Pages");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        //Creating list of Books
        ArrayList<Book> BookList = new ArrayList<Book>();

        //Creating Books
        Book item1 = new Book("Head First Java", "                  Kathy Sierra & Bert Bates", "ABC Publishers", 2545);   // create Array List to store details of books
        item1.displayItems();
        Book item2 = new Book("Big Java", "                         Cay S. Horstmann", "         DEF Publishers", 4545);   // create Array List to store details of books
        item2.displayItems();
        Book item3 = new Book("Introduction To Java Programming ", "Y. Daniel Liang", "          GFR Publishers", 1245);   // create Array List to store details of books
        item3.displayItems();
        Book item4 = new Book("Head First Design Patten", "         Eric Freeman", "             AKC Publishers", 2555);   // create Array List to store details of books
        item4.displayItems();
        Book item5 = new Book("Thinking in Java", "                 Bruce Eckel", "              VKC Publishers", 2695);   // create Array List to store details of books
        item5.displayItems();

        boolean go = true;
        while (go) {

            System.out.print("\nDo you want to View the List Of DVDs ? (0 - No / 1 - Yes) : ");   // asking from user wants view the list of DVDs

            int goValue = sc.nextInt();

            if (goValue == 0) {
                go = false;
                System.out.println("Thank You For Join With Us!!");
                System.exit(0);
            } else if (goValue == 1) {
                go = true;

                System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Film                     Languages               Subtitles                Producer              Actors");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

                //Creating list of DVDs
                ArrayList<DVD> DVDList = new ArrayList<DVD>();

                DVD dvd1 = new DVD("The Nun", "      English", "English/Korean", " Corin Hardy", "     Demián Bichir,Taissa Farmi,Jonas Bloquet,Bonnie Aarons"); // create Array List to store details of DVDs
                dvd1.displayDVDItems();
                DVD dvd2 = new DVD("Baaghi 2", "     Hindi", "  English/Sinhala", "Sajid Nadiadwala", "Tiger Shroff, Ronny Singh,Neha Salgaonkar ,Randeep Hooda"); // create Array List to store details of DVDs
                dvd2.displayDVDItems();
                DVD dvd3 = new DVD("Annabelle", "    English", "English/Korean", " James Wan", "       Annabelle Wallis,Mia,Ward Horton,Kerry O'Malley"); // create Array List to store details of DVDs
                dvd3.displayDVDItems();
                DVD dvd4 = new DVD("Jurassic Park", "English", "English/Korean", " Kathleen Kennedy", "Sam Neill,Jeff Goldblum, Laura Dern,Richard Attenborough"); // create Array List to store details of DVDs
                dvd4.displayDVDItems();
                DVD dvd5 = new DVD("Venom", "        English", "English/Korean", " Avi Arad", "        Tom Hardy, Michelle Williams, Anne Weying,Scott Haze"); // create Array List to store details of DVDs
                dvd5.displayDVDItems();
            }
        }
    }

}