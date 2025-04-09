package models.person;

import models.book.Book;
import models.enums.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private List<Book> borrowedBooks = new ArrayList<>();

    public Reader(String name) {
        super(name);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean purchaseBook(Book book) {
        if(book.getStatus().equals(BookStatus.AVAILABLE)) {
            book.updateStatus(BookStatus.SOLD);
            book.changeOwner(this);
            return true;
        }
        return false;
    }

    public boolean borrowBook(Book book) {
        if(borrowedBooks.size()<5 && book.getStatus().equals(BookStatus.AVAILABLE)) {
            borrowedBooks.add(book);
            book.updateStatus(BookStatus.BORROWED);
            book.changeOwner(this);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if(book.getStatus().equals(BookStatus.BORROWED)) {
            book.updateStatus(BookStatus.AVAILABLE);
            borrowedBooks.remove(book);
            book.changeOwner(null);
            return true;
        }
        return false;

    }

    public void showBook() {

        if (borrowedBooks.isEmpty()) {
            System.out.println(getName() + " şu anda kitap ödünç almamış.");
        } else {
            System.out.println(getName() + " tarafından ödünç alınan kitaplar:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    @Override
    public void whoyouare() {
        System.out.println("I am a reader. My name is" + getName());
    }

    @Override
    public String toString() {
        return "models.person.Reader{name='" +
                getName() +
                "borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}
