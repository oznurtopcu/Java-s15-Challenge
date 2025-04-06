public class StudyBooks extends Book{

    public StudyBooks(long id, Author author, String name, int price, int edition) {
        super(id, author, name, price, edition);
    }

    @Override
    public void displayInfo() {
        System.out.println("Study Book");
    }
}
