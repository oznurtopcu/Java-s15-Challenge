public class Library {

    public static final String NAME = "Workintech Library"; //const

    private static Library instance;

    private Library() {

    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }
}
