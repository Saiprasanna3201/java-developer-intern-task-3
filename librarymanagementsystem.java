import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    int id = library.hashCode() + library.toString().length() + (int) (Math.random() * 100);
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter user name: ");
                    String uname = sc.nextLine();
                    int uid = uname.hashCode() & 0x7fffffff; // simple unique ID
                    library.addUser(new User(uid, uname));
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
