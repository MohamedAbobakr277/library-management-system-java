import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Book findBook(String bookId) {
        return books.get(bookId);
    }

    public Member findMember(String memberId) {
        return members.get(memberId);
    }

    public void checkOutBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null && book.isAvailable()) {
            member.borrowBook(book);

            book.setAvailable(false);
            System.out.println("Success: '" + book.getTitle() + "' checked out to " + member.getName());
        } else {
            System.out.println("Error: Unable to check out book. Either member/book not found or book is unavailable.");
        }
    }

    public void returnBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null && !book.isAvailable()) {
            member.returnBook(book);
            book.setAvailable(true);
            System.out.println("Success: '" + book.getTitle() + "' returned by " + member.getName());
        } else {
            System.out.println("Error: Unable to return book.");
        }
    }

    // Method to display all books
    public void displayBooks() {
        System.out.println("\n--- Library Catalog ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
        System.out.println("---------------------\n");
    }
}