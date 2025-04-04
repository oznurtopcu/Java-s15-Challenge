import java.time.LocalDate;

public class Book {
    private long id;
    private String author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private String date;

    public Book(long id, String author, String name, double price, String status, String edition, String date) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.date = date;
    }


}
