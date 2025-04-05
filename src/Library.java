import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {

    public static final String NAME = "Workintech Library"; //const

    private static Library instance;

    private List<Book> books;
    private Set<Author> authors;

    private Library() {
        this.books = new ArrayList<>();
    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        if(books == null) {
            books = new ArrayList<>();
        }
        if(!books.contains(book))
            books.add(book);

        for(Book showbook: books) {
            showbook.displayInfo();
        }
        System.out.println("Kitap ekleme işlemi başarılı!");
    }

    public List<Book> getBooks() {
        return books.stream().collect(Collectors.toUnmodifiableList());
        //stream'e dönüştürerek listenin bir kopyasını gönderdik
        //salt okunabilir, değiştirilemez, set edilemez
    }
}
