public class Items {

    private int ISBN;
    private String bookName;
    private String authProName;
    private String pubLang;
    private String numOfPages;
    private String actors;


    public Items(){
        this.ISBN = 0;
        this.bookName = "";
        this.authProName = "";
        this.pubLang = "";
        this.numOfPages = "";
        this.actors = "";

    }

    public Items(int ISBN, String bookName, String authProName, String pubLang,String numOfPages, String actors){
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.authProName = authProName;
        this.pubLang = pubLang;
        this.numOfPages = numOfPages;
        this.actors = actors;

    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthProName() {
        return authProName;
    }

    public void setAuthProName(String authProName) {
        this.authProName = authProName;
    }

    public String getPubLang() {
        return pubLang;
    }

    public void setPubLang(String pubLang) {
        this.pubLang = pubLang;
    }

    public String getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(String numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}