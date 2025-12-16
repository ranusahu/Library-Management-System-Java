import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println("ID: " + id + 
                           ", Title: " + title + 
                           ", Author: " + author);
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int choice;

        while (true) {

            System.out.println("\n----- Library Menu -----");
            System.out.println("1. Add New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    books.add(new Book(id, title, author));
                    System.out.println("✅ Book added successfully!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("📚 No books available.");
                    } else {
                        System.out.println("\n--- Book List ---");
                        for (Book b : books) {
                            b.displayBook();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    boolean found = false;

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(searchTitle)) {
                            b.displayBook();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = sc.nextLine();
                    boolean removed = false;

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(removeTitle)) {
                            books.remove(b);
                            removed = true;
                            System.out.println("🗑 Book removed successfully!");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("❌ Book not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Library System 😊");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
