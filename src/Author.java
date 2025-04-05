import java.util.HashSet;
import java.util.Set;

public class Author extends Person{

    private Set<Book> booksWritten = new HashSet<>();

    public Author(String name){
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("I am an author. My name is" + getName());
    }

    public void newBook(Book book) {

        if(book.getAuthor().getName().equals(getName())) {
            booksWritten.add(book);
        }

    }

    public void showBook() {
        System.out.println(getName() + "'s Book List: ");
        for(Book book: booksWritten) {
            System.out.println(" - " + book.getName());
        }
    }
}
