package library.main;

import library.manager.BookManager;
import library.manager.InventoryManager;
import library.manager.LendingManager;
import library.manager.PatronManager;
import library.model.Book;
import library.model.Patron;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LMS {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern ISBN_PATTERN = Pattern.compile("^[1-9][0-9]{3}$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialize Managers
        BookManager bookManager = new BookManager();
        PatronManager patronManager = new PatronManager();

        LendingManager lendingManager = new LendingManager(bookManager, patronManager);
        InventoryManager inventoryManager = new InventoryManager(bookManager);

        while (true) {
            System.out.println("\n*********  Library Management System  ***********");
            System.out.println("1. Add Book");
            System.out.println("2. Add Patron");
            System.out.println("3. Display Available Books");
            System.out.println("4. Display Borrowed Books");
            System.out.println("5. Checkout Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner, bookManager);
                    break;
                case 2:
                    addPatron(scanner, patronManager);
                    break;
                case 3:
                    displayAvailableBooks(inventoryManager);
                    break;
                case 4:
                    displayBorrowedBooks(inventoryManager);
                    break;
                case 5:
                    checkoutBook(scanner, lendingManager, patronManager, bookManager);
                    break;
                case 6:
                    returnBook(scanner, lendingManager, patronManager, bookManager);
                    break;
                case 7:
                    System.out.println("Existing....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

    private static void addBook(Scanner scanner, BookManager bookManager) {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter book author");
        String author = scanner.nextLine();
        System.out.println("Enter book ISBN: ? please use [Non_ZERO_DIGIT][3 DIGITS] ");
        String ISBN = scanner.nextLine();
        if (!ISBN_PATTERN.matcher(ISBN).matches()) {
            System.out.println("Invalid ISBN format.");
            return;
        }
        System.out.println("Enter publication year");
        int year = scanner.nextInt();
        if (year < 0 || year > 2024) {
            System.out.println("Publication year was invalid");
            return;
        }

        Book book = new Book(title, author, ISBN, year);
        bookManager.addBook(book);
        System.out.println("Book added successfully");
    }


    private static void addPatron(Scanner scanner, PatronManager patronManager) {
        System.out.println("Enter Patron ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patron email: ");
        String email = scanner.nextLine();
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("Invalid email format.");
            return;
        }
        Patron patron = new Patron(id, name, email);
        patronManager.addPatron(patron);
        System.out.println("Patron added successfully");
    }


    private static void displayAvailableBooks(InventoryManager inventoryManager) {
        System.out.println("Available Books:");
        int i = 1;
        for (Book book : inventoryManager.getAvailableBooks()) {
            System.out.println("Book No: " + i + " " + book);
            i++;
        }
    }

    private static void displayBorrowedBooks(InventoryManager inventoryManager) {
        System.out.println("Borrowed Books:");
        for (Book book : inventoryManager.getBorrowedBooks()) {
            System.out.println(book);
        }
    }

    private static void checkoutBook(Scanner scanner, LendingManager lendingManager, PatronManager patronManager, BookManager bookManager) {

        System.out.println("Enter patron ID: ");
        String patronId = scanner.nextLine();
        Patron patron = patronManager.searchPatronById(patronId);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        if (!ISBN_PATTERN.matcher(ISBN).matches()) {
            System.out.println("Invalid ISBN Format");
            return;
        }

        Book book = bookManager.searchBooksByISBN(ISBN);
        if (book == null) {
            System.out.println("Book not found.");
        }

        if (lendingManager.checkOutBook(patron, book)) {
            System.out.println("Book checked out successfully");
        } else {
            System.out.println("Book checkout failed.");
        }
    }

    private static void returnBook(Scanner scanner, LendingManager lendingManager, PatronManager patronManager, BookManager bookManager) {

        System.out.println("Enter patron ID: ");
        String patronId = scanner.nextLine();
        Patron patron = patronManager.searchPatronById(patronId);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Enter book ISBN:");
        String ISBN = scanner.nextLine();
        if (!ISBN_PATTERN.matcher(ISBN).matches()) {
            System.out.println("Invalid ISBN Format");
            return;
        }

        Book book = bookManager.searchBooksByISBN(ISBN);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (lendingManager.returnBook(patron, book)) {
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book return failed");
        }
    }
}
