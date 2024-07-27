package library.manager;

import library.model.Book;
import library.model.Patron;

public class LendingManager {

    private BookManager bookManager;
    private PatronManager patronManager;

    public LendingManager(BookManager bookManager , PatronManager patronManager)
    {
        this.bookManager = bookManager;
        this.patronManager = patronManager;
    }

    /**
     * Checks out a book to a patron.
     *
     * @param patron , the patron who is checking out the book
     * @param book , the book to be checked out
     * @return , true if the checkout was successful, false otherwise
     */
    public boolean checkOutBook(Patron patron , Book book)
    {
        if(bookManager.getBooks().contains(book) && book.getLoaned()==null)
        {
            book.setLoaned(patron);
            patron.addBorrowedBook(book);
            return true;
        }
        return false;
    }

    /**
     * Returns a book from a patron
     *
     * @param patron , the patron who is returning the book
     * @param book , the book to be returned
     * @return true , if the return was successful, false otherwise
     */
    public boolean returnBook(Patron patron, Book book)
    {
        if(patron.getBorrowedBooks().contains(book))
        {
            book.setLoaned(null);
            patron.removeBorrowedBook(book);
            return true;
        }
        return false;
    }

}
