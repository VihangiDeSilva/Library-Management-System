package dto;

public class Reader {

    // declare variables
    private int readerID;
    private String readerName;
    private String readerEmail;
    private int mobNumber;

    //create constructor
    public Reader(int readerID, String readerName, String readerEmail, int mobNumber) {
        this.readerID = readerID;
        this.readerName = readerName;
        this.readerEmail = readerEmail;
        this.mobNumber = mobNumber;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;

    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail;
    }

    public int getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(int mobNumber) {
        this.mobNumber = mobNumber;
    }


}
