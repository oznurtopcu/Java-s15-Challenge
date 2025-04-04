public class Author extends Person{

    public Author(String name){
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("I am an author. My name is" + getName());
    }
}
