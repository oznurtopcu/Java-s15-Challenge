import java.util.*;

public class Library {

    public static final String NAME = "Workintech Library"; //const

    private static Library instance;

    private Map<Long,Book> books;
    private List<Reader> readers;

    Book[] initialBooks = {
            new Journals(101L, new Author("Carl Sagan"), "Cosmos Insights", 60, 1),
            new Journals(102L, new Author("Marie Curie"), "Radioactivity Research", 70, 2),
            new Journals(103L, new Author("Alan Turing"), "Computational Logic", 80, 1),
            new Journals(104L, new Author("Ada Lovelace"), "Analytical Engine", 55, 1),
            new Journals(105L, new Author("Jane Goodall"), "Chimp Behavior", 65, 1),

            new Magazines(201L, new Author("Oprah Winfrey"), "Life & Wellness", 30, 2),
            new Magazines(202L, new Author("Elon Musk"), "Future Tech", 40, 1),
            new Magazines(203L, new Author("Emma Watson"), "Equality Monthly", 25, 3),
            new Magazines(204L, new Author("Barack Obama"), "Leadership Digest", 35, 1),
            new Magazines(205L, new Author("Greta Thunberg"), "Climate Watch", 28, 2),

            new StudyBooks(301L, new Author("Richard Feynman"), "Quantum Mechanics", 90, 1),
            new StudyBooks(302L, new Author("Noam Chomsky"), "Linguistics 101", 75, 2),
            new StudyBooks(303L, new Author("Stephen Hawking"), "Black Holes", 85, 1),
            new StudyBooks(304L, new Author("Daniel Kahneman"), "Thinking Fast & Slow", 70, 1),
            new StudyBooks(305L, new Author("Malcolm Gladwell"), "Outliers", 65, 3),

            new StudyBooks(401L, new Author("Yuval Noah Harari"), "Sapiens", 80, 2),
            new Journals(402L, new Author("Neil deGrasse Tyson"), "Astro Weekly", 60, 1),
            new Magazines(403L, new Author("Michelle Obama"), "Inspiration Today", 30, 2),
            new StudyBooks(404L, new Author("Angela Duckworth"), "Grit", 72, 1),
            new Magazines(405L, new Author("Bill Gates"), "Innovation Quarterly", 35, 1)
    };



    private Library() {
        this.books = new HashMap<>();
        this.readers = new ArrayList<>();
//      Librarian librarian = new Librarian("user1", "123456", this);

        for (Book book : initialBooks) {
            books.put(book.getId(), book);
        }
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
            System.out.println("ID: " + book.getId() + "  || NAME: " + book.getName() + "  || AUTHOR: " + book.getAuthor().getName());
        }
    }

    public void showBook(List<Book> books) {
        for(Book book: books) {
            System.out.println("ID: " + book.getId() + "  || NAME: " + book.getName() + "  || AUTHOR: " + book.getAuthor().getName());
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
//                book.getAuthor().addNewBook(book);
            }
        }
        return matching;
    }




}
