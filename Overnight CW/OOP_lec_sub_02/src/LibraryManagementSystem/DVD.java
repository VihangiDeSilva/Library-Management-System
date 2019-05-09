package LibraryManagementSystem;

public class DVD {

    private String nameOfTheFilm;     // declare variables
    private String languages;
    private String subtitles;
    private String nameOfTheProducer;
    private String actors;

    // creating constructor for declared variables
    public DVD(String nameOfTheFilm, String languages, String subtitles, String nameOfTheProducer, String actors) {
        this.nameOfTheFilm = nameOfTheFilm;
        this.languages = languages;
        this.subtitles = subtitles;
        this.nameOfTheProducer = nameOfTheProducer;
        this.actors = actors;
    }

    public void displayDVDItems() {// create method for display DVD list

            //Traversing list
                System.out.println(nameOfTheFilm + "             " + languages + "                 " + subtitles + "          " + nameOfTheProducer + "      " + actors);


            }
        }


