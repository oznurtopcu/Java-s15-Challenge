import java.util.*;

public class Library {

    public static final String NAME = "Workintech Library"; //const

    private static Library instance;

    private Map<Long,Book> books;
    private List<Reader> readers;

    private Library() {
        this.books = new HashMap<>();
        this.readers = new ArrayList<>();
//      Librarian librarian = new Librarian("user1", "123456", this);
    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }


    public Map<Long, Book> getBooks(){
        return Collections.unmodifiableMap(books);
    }

    public List<Reader> getReaders() {
        return Collections.unmodifiableList(readers);
    }

    public void addNewBook(Book book) {
        if(!books.containsKey(book.getId()))
            books.put(book.getId(), book);
        System.out.println("Kitap ekleme işlemi başarılı!");
    }

    public boolean lendBook(Book book, Reader reader) {
        if (reader.borrowBook(book)) {
            System.out.println(reader.getName() + " kitabı ödünç aldı: " + book.getName());
        } else {
            System.out.println("Kitap ödünç verilemedi: " + book.getName());
        }

        return reader.borrowBook(book);
    }

    public boolean takeBackBook(Book book, Reader reader) {
        return reader.returnBook(book);
    }

    public void showBook() {
        System.out.println(NAME + "'s Book List: ");
        for(Book book: books.values()) {
            System.out.println("ID: " + book.getId() + "NAME: " + book.getName() + "AUTHOR: " + book.getAuthor().getName());
        }
    }

    public void showBook(List<Book> books) {
        for(Book book: books) {
            System.out.println("ID: " + book.getId() + "NAME: " + book.getName() + "AUTHOR: " + book.getAuthor().getName());
        }
    }

    public Book getBookById(long id) {
        return books.get(id);
    }

    public List<Book> getBookByName(String name) {
        List<Book> matching = new ArrayList<>();

        for (Book book: books.values()) {
            if(book.getName().trim().equalsIgnoreCase(name.trim())) {
                matching.add(book);
            }
        }
        return matching;
    }

    public List<Book> getBookByAuthor(String author) {
        List<Book> matching = new ArrayList<>();

        for (Book book: books.values()) {
            if(book.getAuthor().getName().trim().equalsIgnoreCase(author.trim())) {
                matching.add(book);
            }
        }
        return matching;
    }




}
