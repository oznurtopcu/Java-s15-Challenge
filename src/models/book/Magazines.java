package models.book;

import models.person.Author;

public class Magazines extends Book {

    public Magazines(long id, Author author, String name, int price, int edition) {
        super(id, author, name, price, edition);
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine models.book.Book");
    }
}
