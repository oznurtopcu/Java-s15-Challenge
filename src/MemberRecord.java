import java.time.LocalDate;

public class MemberRecord {
    private long memberId;
    private MemberType memberType;
    private LocalDate dateOfMembership;
    private int bookIssued;
    private final int maxBookLimit = 5;
    private String name;
    private String address;
    private String phoneNumber;

    public MemberRecord(long memberId, MemberType type, LocalDate dateOfMembership, int bookIssued, String name, String address, String phoneNumber) {
        this.memberId = memberId;
        this.memberType = type;
        this.dateOfMembership = dateOfMembership;
        this.bookIssued = bookIssued;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public MemberRecord getMember() {
        return this;
    }

    public long getMemberId() {
        return memberId;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public int getBookIssued() {
        return bookIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void increaseBookIssue() {
        if(bookIssued < maxBookLimit) {
            bookIssued++;
        }else{
            System.out.println("Üye max kitap limitine ulaşmıştır.");
        }
    }
    public void increaseBookIssue(int x) {
        if(bookIssued + x < maxBookLimit) {
            bookIssued += x;
        }else{
            System.out.println("Toplam limit aşılıyor.");
        }
    }



    public void decreaseBookIssue() {
        if(bookIssued > 0) {
            bookIssued--;
        }else{
            System.out.println("Üye min kitap sayısı sıfırın altında olamaz.");
        }
    }
    public void decreaseBookIssue(int x) {
        if(bookIssued - x  > 0) {
            bookIssued -= x;
        }else{
            System.out.println("Üye min kitap sayısı sıfırın altında olamaz.");
        }
    }

    public void payBill() {
        switch (memberType) {
            case STUDENT:
                System.out.println("15TL ödendi.");

            case TEACHER:
                System.out.println("25TL ödendi.");

            case FULL:
                System.out.println("250TL ödendi.");

            default:
                System.out.println("Üyelik işlemi tamamlanamadı. Lütfen üyelik tipi seçiniz.");
        }
    }
}
