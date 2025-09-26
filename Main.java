import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some sample data
        library.addBook(new Book("B001", "The Lord of the Rings", "J.R.R. Tolkien"));
        library.addBook(new Book("B002", "Pride and Prejudice", "Jane Austen"));
        library.addMember(new Member("M001", "Alice"));
        library.addMember(new Member("M002", "Bob"));

        while (true) {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Display All Books");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter your Member ID: ");
                    String memberIdCo = scanner.nextLine();
                    System.out.print("Enter the Book ID to check out: ");
                    String bookIdCo = scanner.nextLine();
                    library.checkOutBook(memberIdCo, bookIdCo);
                    break;
                case 3:
                    System.out.print("Enter your Member ID: ");
                    String memberIdCi = scanner.nextLine();
                    System.out.print("Enter the Book ID to return: ");
                    String bookIdCi = scanner.nextLine();
                    library.returnBook(memberIdCi, bookIdCi);
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}