package LibraryManagementSystem;

public class DVD extends LibraryItem {

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

    @Override
    public void details() {
        //Traversing list
        System.out.println(nameOfTheFilm + "             " + languages + "                 " + subtitles + "          " + nameOfTheProducer + "      " + actors);

    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void add(DVD dvd) {

    }
}


