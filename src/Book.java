import java.time.LocalDate;

public abstract class Book {
    private long id;
    private Author author;
    private String name;
    private BookStatus status;
    private LocalDate date;
    private Reader owner;

    public Book(long id, Author author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.status = BookStatus.AVAILABLE;
        this.date = LocalDate.now();
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
    public LocalDate getDate() {
        return date;
    }
    public Reader getOwner() {
        return owner;
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

    public void setDate(LocalDate date) {
        this.date = date;
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
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", owner='" + owner + '\'' +
                '}';
    }
}
