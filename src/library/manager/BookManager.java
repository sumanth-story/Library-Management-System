package library.manager;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> books;

    public BookManager()
    {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library's inventory
     *
     * @param book
     */
    public void addBook(Book book)
    {
        books.add(book);
    }


    /**
     * Removes a book from the library's inventory
     *
     * @param book
     */
    public void removeBook(Book book)
    {
        books.remove(book);
    }

    /**
     *
     * @param old_book , the existing book to be updated
     * @param new_book , the new book details to replace the old book
     */
    public void updateBook(Book old_book, Book new_book)
    {
        int pos = books.indexOf(old_book);
        if(pos != -1)
        {
            books.set(pos,new_book);
        }
    }


    /**
     * Searches for books by their title [ ONE TO MANY ]
     *
     * @param title , the title to search for
     * @return , a list of books with the matching title
     */
    public List<Book> searchBooksByTitle(String title)
    {
        List<Book> result = new ArrayList<>();
        for(Book book : books)
        {
            if(book.getTitle().equalsIgnoreCase(title)){
                result.add(book);
            }
        }
        return result;
    }


    /**
     * Searches for books by their author. [ ONE TO MANY ]
     *
     * @param author , the author to search for
     * @return , a list of books with the matching author
     */
    public List<Book> searchBooksByAuthor(String author)
    {
        List<Book> result = new ArrayList<>();
        for(Book book : books)
        {
            if(book.getAuthor().equalsIgnoreCase(author))
            {
                result.add(book);
            }
        }
        return result ;
    }

    /**
     * Searches for a book by its ISBN [ ONE TO ONE ]
     *
     * @param ISBN, the ISBN to search for
     * @return , the book with the matching ISBN, or null if no match is found
     */
    public Book searchBooksByISBN(String ISBN)
    {
        for(Book book : books)
        {
            if(book.getISBN().equalsIgnoreCase(ISBN))
            {
                return book ;
            }
        }
        return null;
    }


    /**
     * Gets the list of all books in the library's inventory.
     *
     * @return , the list of books
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
