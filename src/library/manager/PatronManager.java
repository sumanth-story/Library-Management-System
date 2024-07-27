package library.manager;

import library.model.Book;
import library.model.Patron;

import java.util.ArrayList;
import java.util.List;

public class PatronManager {

    private List<Patron> patrons;

    public PatronManager()
    {
        this.patrons = new ArrayList<>();
    }

    /**
     * Adds a new patron to the library system
     *
     * @param patron, the patron to be added
     */
    public void addPatron(Patron patron)
    {
        patrons.add(patron);
    }

    /**
     * Updates an existing patron's information in the library sytem.
     *
     * @param old_patron , the existing patron to be updated
     * @param new_patron , the new patron details to replace to old patron.
     */
    public void addPatron(Patron old_patron , Patron new_patron)
    {
        int pos = patrons.indexOf(old_patron);
        if(pos != -1)
        {
            patrons.set(pos,new_patron);
        }
    }


    /**
     * Tracks the borrowing history of a patron by adding to their borrowed books list
     *
     * @param patron , the patron who borrowed the book
     * @param book , the book that was borrowed
     */
    public void trackBorrowingHistory(Patron patron, Book book){
        patron.addBorrowedBook(book);
    }

    /**
     * Gets the list of all patrons in the library system.
     *
     * @return the list of patrons
     */
    public List<Patron> getAllPatrons()
    {
        return patrons;
    }


    /**
     * Searches for a patron by their ID
     *
     * @param id , the ID to search for
     * @return , the patron with the matching ID, or null if no match is found
     */
    public Patron searchPatronById(String id)
    {
        for(Patron patron : patrons)
        {
            if(patron.getId().equals(id))
                {
                    return patron;
                }
        }
        return null;
    }

}
