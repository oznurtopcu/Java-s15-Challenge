import java.util.List;
import java.util.Objects;

public class Librarian {
    private String username;
    private String password;
    private Library library;


    public Librarian(String username, String password, Library library) {
        this.username = username;
        this.password = password;
        this.library = library;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Search İşlemleri

    public Book searchBookById(long id) {
        return library.getBookById(id);
    }

    public List<Book> searchBookByName(String name) {
        return library.getBookByName(name);
    }

    public List<Book> searchBookByAuthor(String author) {
        return library.getBookByName(author);
    }

    public boolean returnBook(Book book, Reader reader) {
        return library.takeBackBook(book, reader);
    }

    //okuyucu belli değilse, önce okuyucuyu bulup
    public boolean returnBook(Book book) {
        if(book.getStatus().equals(BookStatus.BORROWED)) {
//            book.updateStatus(BookStatus.AVAILABLE);
//            book.changeOwner(null);

            for(Reader reader: library.getReaders()) {
                for(Book book1: reader.getBorrowedBooks()) {
                    if(book.equals(book1)) {
                        returnBook(book1, reader);
                    }
                }
            }
            return true;
        }
        return false;
    }


    // Giriş işlemi için doğrulama (opsiyonel olarak eklenebilir)
    public boolean validate(String inputName, String inputPassword) {
        return this.username.equals(inputName) && this.password.equals(inputPassword);
    }

    public MemberType verifyMember(MemberRecord member) {
        if(member.getMemberType() == null) {
            System.out.println("Üye kayıtlı değil");
        }
        return member.getMemberType();
    }






//    public Librarian(String name) {
//        super(name);
//    }
//
//    @Override
//    public void whoyouare() {
//        System.out.println("I am a librarian. My name is " + getName());
//    }

//    private String username = "library123";
//    private String password = "123456";
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Librarian librarian = (Librarian) o;
//        return Objects.equals(username, librarian.username) && Objects.equals(password, librarian.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, password);
//    }
}
