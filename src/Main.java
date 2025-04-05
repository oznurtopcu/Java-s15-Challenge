import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("---------------------------------");
            System.out.println(Library.NAME + " Kütüphane Yönetim Sistemi'ne hoş geldiniz!");
            System.out.println("------");
            System.out.println("MENU:");
            System.out.println("1. Kitap Ekle: ");
            System.out.println("2. Kitap Seç: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
            System.out.println("3. Kitap Bilgilerini Güncelle: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
            System.out.println("4. Kitap Sil: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
            System.out.println("5. Kategorinin Tüm Kitaplarını Listele: ");
            System.out.println("6. Yazarın Tüm Kitaplarını Listele: ");
            System.out.println("7. Kitabı Ödünç Al: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
            System.out.println("8. Kitabı Teslim Et: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
            System.out.println("9. Çıkış Yap: ");
            System.out.println("---------------------------------");
            System.out.println("Lütfen bir menü seçiniz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Kitap ekleme menüsü aktif.");
                    library.addBook(new Book(1L, "Oğuz Atay", "Tutunamayanlar") {
                    });
                    library.addBook(new Book(2L, "George Orwell", "1984") {
                    });
                    library.addBook(new Book(3L, "Anthony Burgess", "Otomatik Portakal") {
                    });
                    break;
                case 2:
                    System.out.println("Kitap seçme menüsü aktif.");
                    break;
                case 3:
                    System.out.println("Kitap güncelleme menüsü aktif.");
                    break;
                case 9:
                    running = false;
                    System.out.println("Programdan çıkılıyor.");
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }

        }

        scanner.close();

    }
}