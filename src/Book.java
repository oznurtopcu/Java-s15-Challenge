public abstract class Book {
    private long id;
    private String author;
    private String name;
    private boolean isBorrowed;
    private String date;
    private String owner;

    public Book(long id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.isBorrowed = false;

    }

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    public void changeOwner(String owner) {
        this.owner = owner;
    }
    public void updateStatus() {
        this.isBorrowed = !isBorrowed;
    }
    public void displayInfo() {
        System.out.println( "Kitap ID: " + id + " " +
                "Kitap adı: " + name + " " +
                "Kitap Yazarı: " + author
                );
    }
}
