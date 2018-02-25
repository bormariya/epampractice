package javase01.t06;

/**
 * The class describes the state and behavior of the notebook.
 * Objects of this class have information in array of notes,
 * that are objects of the {@link Note}
 */
public class Notebook {
    /**
     * Notes in the notebook
     */
    private Note[] notes;

    /**
     * Constructor with parameter
     * @param size defines quantity of allowable notes in the notebook
     */
    Notebook(int size){
        notes = new Note[size];
    }

    /**
     * Add a note in the notebook
     * @param note - object of {@link Note} class
     */
    public void addNote(Note note){
        for (int i = 0; i < notes.length; i++) {
            if(notes[i] == null){
                notes[i] = note;
            }

        }
    }

    /**
     * Remove the note in the notebook
     * @param note - object of {@link Note} class
     */
    public void removeNote(Note note){
        for (int i = 0; i < notes.length; i++) {
            if(notes[i] == note){
                notes[i] = null;
            }

        }
    }

    /**
     * Edit note <code>note</code> in the notebook replacing with string <code>str</code>
     * @param note - object of {@link Note} class
     * @param str - new string
     */
    public void editNote(Note note, String str){
        note.setNote(str);
    }

    /**
     * @return all notes from the notebook
     */
    public Note[] getAllNotes(){
        return notes;
    }

    /**
     * @return all notes from the notebook in a {@link String} format
     */
    public String[] getAllNotesAsStrings(){
        String[] arrayOfNotes = new String[this.notes.length];
        for (int i = 0; i < this.notes.length; i++) {
            arrayOfNotes[i] = notes[i].getNote();
        }
         return arrayOfNotes;
    }
}
