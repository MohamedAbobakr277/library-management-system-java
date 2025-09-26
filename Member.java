import java.util.ArrayList;

public class Member {
    private String memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: '" + name + "', Borrowed Books: " + borrowedBooks.size();
    }
}