public class Reader extends Person{

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("I am a reader. My name is" + getName());
    }
}
