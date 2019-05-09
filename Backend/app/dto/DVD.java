package dto;

public class DVD extends LibraryItem {

    // declare variables
    public String languages;
    public String subtitles;
    public String nameOfTheProducer;
    public String actors;

        // creating constructor for declared variables
    public DVD(int isbn, String itemName, Reader reader, String languages, String subtitles, String nameOfTheProducer, String actors) {
        super(isbn, itemName, reader);
        this.languages = languages;
        this.subtitles = subtitles;
        this.nameOfTheProducer = nameOfTheProducer;
        this.actors = actors;
    }

    //getters and setters
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getNameOfTheProducer() {
        return nameOfTheProducer;
    }

    public void setNameOfTheProducer(String nameOfTheProducer) {
        this.nameOfTheProducer = nameOfTheProducer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}




