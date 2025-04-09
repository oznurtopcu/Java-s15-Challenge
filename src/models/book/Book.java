package models.book;

import models.enums.BookStatus;
import models.person.Author;
import models.person.Reader;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Book {
    private long id;
    private Author author;
    private String name;
    private int price;
    private int edition;
    private BookStatus status;
    private LocalDate dateOfPurchase;
    private Reader owner;

    public Book(long id, Author author, String name, int price, int edition) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.status = BookStatus.AVAILABLE;
        this.dateOfPurchase = LocalDate.now();
    }

    public long getId() {
        return id;
    }
    public Author getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public BookStatus getStatus() {
        return status;
    }
    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
    public Reader getOwner() {
        return owner;
    }
    public int getPrice() {
        return price;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDateOfPurchase(LocalDate date) {
        this.dateOfPurchase = date;
    }
    public void changeOwner(Reader owner) {
        this.owner = owner;
    }
    public void updateStatus(BookStatus status) {
        this.status = status;
    }
    public abstract void displayInfo();

    @Override
    public String toString() {
        return " Book {" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", date=" + dateOfPurchase +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id ; //&& Objects.equals(author, book.author) && Objects.equals(name, book.name)
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); //author, name
    }
}
