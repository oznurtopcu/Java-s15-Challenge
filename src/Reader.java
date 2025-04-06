import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{

    private List<Book> borrowedBooks = new ArrayList<>();

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("I am a reader. My name is" + getName());
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean purchaseBook(Book book) {
        if(book.getStatus().equals(BookStatus.AVAILABLE)) {
            book.updateStatus(BookStatus.SOLD);
            return true;
        }
        return false;
    }

    public boolean borrowBook(Book book) {
        if(borrowedBooks.size()<5 && book.getStatus().equals(BookStatus.AVAILABLE)) {
            borrowedBooks.add(book);
            book.updateStatus(BookStatus.BORROWED);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if(book.getStatus().equals(BookStatus.BORROWED)) {
            book.updateStatus(BookStatus.AVAILABLE);
            borrowedBooks.remove(book);
            return true;
        }
        return false;

    }

    public void showBook() {
        System.out.println("Borrowed book list: ");
        for(Book book: borrowedBooks) {
            System.out.println(book.toString());
        }
    }

}
