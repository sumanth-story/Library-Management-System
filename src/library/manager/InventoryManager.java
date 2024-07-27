package library.manager;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private BookManager bookManager;

    public InventoryManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    /**
     * Gets the list of available books in the library's inventory.
     *
     * @return a list of available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookManager.getBooks()) {
            if (book.getLoaned() == null) // Check if the book is not loaned out
            {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * Gets the list of borrowed books in the library's inventory.
     *
     * @return , a list of borrowed books
     */
    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : bookManager.getBooks()) {
            if (book.getLoaned() != null) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

}
