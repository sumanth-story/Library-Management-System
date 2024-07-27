package library.model;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String email;
    private  List<Book> borrowedBooks;

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    //Getters
    public String getId()  { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    //Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    /**
     * Adds a book to the list of borrowed books
     *
     * @param book , the book to be added
     */
    public void addBorrowedBook(Book book)
    {
        borrowedBooks.add(book);
    }


    /**
     * Removes a book from the list of borrowed books
     *
     * @param book
     */
    public void removeBorrowedBook(Book book)
    {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Patron Details " +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", borrowedBooks: " + borrowedBooks ;
    }


}
