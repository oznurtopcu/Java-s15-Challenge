import java.util.HashSet;
import java.util.Set;

public class Author extends Person{

    private Set<Book> booksWritten = new HashSet<>();

    public Author(String name){
        super(name);
    }

    public void addNewBook(Book book) {

        if(book.getAuthor().getName().equals(getName())) {
            booksWritten.add(book);
        }

    }

    public void showBook() {

        if (booksWritten.isEmpty()) {
            System.out.println(getName() + " yazarına ait kitap bulunamadı.");
        } else {
            System.out.println(getName() + " tarafından yazılmış kitaplar:");
            for (Book book : booksWritten) {
                System.out.println("- " + book.getName());
            }
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("I am an author. My name is" + getName());
    }

    @Override
    public String toString() {
        return "Author{name='" +
                getName() +
                "booksWritten=" + booksWritten.size() +
                '}';
    }
}
