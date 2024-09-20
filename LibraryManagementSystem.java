import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author, true));
        System.out.println("Book added successfully!");
    }

    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = findBookById(id);
        if (book != null) {
            System.out.print("Enter new Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter new Author: ");
            String author = scanner.nextLine();

            book.setTitle(title);
            book.setAuthor(author);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    lms.addBook();
                    break;
                case 2:
                    lms.updateBook();
                    break;
                case 3:
                    lms.deleteBook();
                    break;
                case 4:
                    lms.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
