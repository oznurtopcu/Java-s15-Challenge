import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public static final String NAME = "Workintech Library"; //const

    private static Library instance;

    private Map<Long,Book> books;
    private List<Reader> readers;

    private Library() {
        this.books = new HashMap<>();
        this.readers = new ArrayList<>();
    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }


//    BIR ONCEKI COMMITTEN KALAN KODLAR
//
//    public void addBook(Book book) {
//        if(books == null) {
//            books = new ArrayList<>();
//        }
//        if(!books.contains(book))
//            books.add(book);
//
//        for(Book showbook: books) {
//            showbook.displayInfo();
//        }
//        System.out.println("Kitap ekleme işlemi başarılı!");
//    }
//
//    public List<Book> getBooks() {
//        return books.stream().collect(Collectors.toUnmodifiableList());
//        //stream'e dönüştürerek listenin bir kopyasını gönderdik
//        //salt okunabilir, değiştirilemez, set edilemez
//    }
//
//

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
