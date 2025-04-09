package models.book;

import models.person.Author;

public class Journals extends Book {

    public Journals(long id, Author author, String name, int price, int edition) {
        super(id, author, name, price,edition);
    }

    @Override
    public void displayInfo() {
        System.out.println("models.book.Journals models.book.Book");
    }
}
