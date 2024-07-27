package library.model;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private Patron loaned_patron; // The patron to whom the book is currently borrowed, if any

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.loaned_patron = null;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


    public Patron getLoaned() {
        return loaned_patron;
    }

    public void setLoaned(Patron patron) {
        this.loaned_patron = patron;
    }

    @Override
    public String toString() {
        return "-> " + "Title: '" + title + '\'' + ", Author: '" + author + '\'' +
                ", ISBN: '" + ISBN + '\'' + ", Publication Year: " + publicationYear;
    }

}
