package javase01.t06;

/**
 * Here is description of the behavior
 * and state of one record in a notebook
 */
public class Note {
    /**
     * Content of the note
     */
    private String note;

     /**
     * Constructor with parameter
     * @param note defines content of the note
     *
     */
    Note(String note){
        this.note = note;
    }

    /**
     * Set the contents of the note using the <code>newNote</code> parameter
     * @param newNote defines content of the note
     */
    public void setNote(String newNote){
        this.note = newNote;
    }

    /**
     * @return content of the note of {@link String} format
     */
    public String getNote(){
        return this.note;
    }
}
