import java.util.Objects;

public class Librarian extends Person {

    public Librarian(String name) {
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("I am a librarian. My name is " + getName());
    }

    private String username = "library123";
    private String password = "123456";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(username, librarian.username) && Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
