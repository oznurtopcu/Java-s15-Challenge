import models.book.Book;
import models.book.Journals;
import models.book.Magazines;
import models.book.StudyBooks;
import models.enums.BookStatus;
import models.person.Author;
import models.person.Reader;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Library library = Library.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRunning = true;

        System.out.println("📚 " + Library.NAME + " Kütüphane Yönetim Sistemi'ne hoş geldiniz! 📚");

        while(isRunning) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewBook();
                    System.out.println("\nKütüphanedeki kitaplar ");
                    library.showBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:
                    searchBookById();
                    break;
                case 4:
                    searchBookByName();
                    break;
                case 5:
                    searchBookByCategory();
                    break;
                case 6:
                    searchBookByAuthor();
                    break;
                case 7:
                    deleteBook();
                    break;
                case 8:
                    borrowBook();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Çıkış yapılıyor!");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin!");
            }

        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
        System.out.println("1 - Yeni kitap ekle");
        System.out.println("2 - Tüm Kitapları Listele");
        System.out.println("3 - Kitap ara (ID ile)");
        System.out.println("4 - Kitap ara (İsim ile)");
        System.out.println("5 - Kategorinin Tüm Kitaplarını Listele");
        System.out.println("6 - Yazarın Tüm Kitaplarını Listele");
        System.out.println("7 - Kitap Sil");
        System.out.println("8 - Kitap Ödünç Al");
        System.out.println("0 - Çıkış");

//       System.out.println("3. Kitap Bilgilerini Güncelle: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
//       System.out.println("4. Kitap Sil: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
//       System.out.println("7. Kitabı Ödünç Al: (ID, İsim veya Yazar bilgisi girilmelidir!) ");
//       System.out.println("8. Kitabı Teslim Et: (ID, İsim veya Yazar bilgisi girilmelidir!) ");

    }

    private static int getUserChoice() {
        System.out.print("Seçiminiz: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void addNewBook() {
        System.out.println("--- Yeni Kitap Ekle ---");

        System.out.print("Kitap ID: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.print("Kitap Adı: ");
        String name = scanner.nextLine();

        System.out.print("Yazar Adı: ");
        String authorName = scanner.nextLine();
        // Yeni bir Author nesnesi oluşturuyoruz. (Mevcut bir yazar listesi istersen, onu kontrol edebilirsin.)
        Author author = new Author(authorName);

        System.out.print("Fiyat: ");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.print("Baskı (Edition): ");
        int edition = Integer.parseInt(scanner.nextLine());

        System.out.println("Kitap Türü Seçiniz:");
        System.out.println("1 - Journal");
        System.out.println("2 - StudyBook");
        System.out.println("3 - Magazine");
        int type = Integer.parseInt(scanner.nextLine());

        Book newBook = null;
        switch (type) {
            case 1:
                newBook = new Journals(id, author, name, price, edition);
                break;
            case 2:
                newBook = new StudyBooks(id, author, name, price, edition);
                break;
            case 3:
                newBook = new Magazines(id, author, name, price, edition);
                break;
            default:
                System.out.println("Geçersiz kitap türü seçildi.");
                return;
        }

        // Kitabı yazara ekle (models.person.Author sınıfında addBook metodunun var olduğunu varsayıyoruz.)
        author.addNewBook(newBook);

        // Kitabı kütüphaneye ekle
        library.addNewBook(newBook);

        System.out.println("Kitap başarıyla eklendi:\n" + newBook);
    }

    private static void getAllBooks() {
        System.out.println("Tüm kitaplar listeleniyor...");
        library.showBook();
    }

    private static void searchBookById() {

        System.out.println("Kitap ID giriniz: ");
        long id = Long.parseLong(scanner.nextLine());
        Book book = library.getBookById(id);

        if (book != null) {
            System.out.println("Kitap bulundu:\n" + book);
        } else {
            System.out.println("ID ile eşleşen kitap bulunamadı.");
        }

    }

    private static void searchBookByName() {
        System.out.print("Kitap ismi giriniz: ");
        String name = scanner.nextLine();
        List<Book> books = library.getBookByName(name);

        if(books.isEmpty()) {
            System.out.println("İsim ile eşleşen herhangi bir kitap bulunamadı.");
        }else {
            System.out.println("Eşleşen Kitaplar: ");
            library.showBook(books);
        }
    }

    private static void searchBookByCategory() {
        System.out.println("Kitap Türü Seçiniz:");
        System.out.println("1 - Journal");
        System.out.println("2 - StudyBook");
        System.out.println("3 - Magazine");

        List<Book> matching = null;

        int categoryChoice = Integer.parseInt(scanner.nextLine());

        Class<?> categoryClass = switch (categoryChoice) {
            case 1 -> StudyBooks.class;
            case 2 -> Journals.class;
            case 3 -> Magazines.class;
            default -> null;
        };

        if (categoryClass == null) {
            System.out.println("Geçersiz kategori seçimi!");
        } else {
            List<Book> filteredBooks = library.getBooks().values().stream()
                    .filter(book -> categoryClass.isInstance(book))
                    .toList();

            if (filteredBooks.isEmpty()) {
                System.out.println("Bu kategoriye ait kitap bulunamadı.");
            } else {
                filteredBooks.forEach(System.out::println);
            }
        }

    }

    private static void searchBookByAuthor() {
        System.out.print("Yazar ismi giriniz: ");
        String authorName = scanner.nextLine();
        List<Book> books = library.getBookByAuthor(authorName);

        if(books.isEmpty()) {
            System.out.println("Yazar ile eşleşen herhangi bir kitap bulunamadı.");
        }else {
            System.out.println("Yazara Ait Kitaplar: ");
            library.showBook(books);
        }

    }

    private static void deleteBook() {
        System.out.println("Silinecek Kitap ID Bilgisini Giriniz: ");
        long id = Long.parseLong(scanner.nextLine());

        Book bookToDelete = library.getBookById(id);
        if (bookToDelete != null) {
            library.deleteBook(bookToDelete);
            System.out.println(bookToDelete.getId() + " ID'li kitap başarıyla silindi.");
        } else {
            System.out.println("Bu ID ile eşleşen bir kitap bulunamadı.");
        }
    }

    private static void borrowBook() {
        System.out.print("Okuyucu adını girin: ");
        String readerName = scanner.nextLine();

        Reader foundReader = null;
        for (Reader reader : library.getReaders()) {
            if (reader.getName().equalsIgnoreCase(readerName)) {
                foundReader = reader;
                break;
            }
        }

        if (foundReader == null) {
            System.out.println("Okuyucu bulunamadı!");
            //TODO: eğer okuyucu bulunamadıysa yeni okuyucu olarak kaydedilebilir
            return;
        }

        System.out.print("Ödünç alınacak kitabın ID'sini girin: ");
        long bookId = Long.parseLong(scanner.nextLine());

        Book bookToBorrow = library.getBookById(bookId);

        if (bookToBorrow == null) {
            System.out.println("Kitap bulunamadı!");
            return;
        }

        if (bookToBorrow.getStatus() != BookStatus.AVAILABLE) {
            System.out.println("Kitap kiralanmaya müsait değil. Kitap durumu: " );
//            if(bookToBorrow.getStatus() == BookStatus.BORROWED) System.out.println("Kiralanmış");
//            if(bookToBorrow.getStatus() == BookStatus.SOLD) System.out.println("Satın alınmış");
            return;
        }

        library.lendBook(bookToBorrow, foundReader);

    }
}