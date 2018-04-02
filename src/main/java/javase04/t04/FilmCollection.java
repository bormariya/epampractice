package javase04.t04;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@SuppressWarnings("unused")
public class FilmCollection implements Serializable{

    private Map<Film, Actor[]> collection;

    private FilmCollection(){
        this.collection = new HashMap<>();
    }

    public static FilmCollection create(){
        return new FilmCollection();
    }

    @SuppressWarnings("UnusedReturnValue")
    public FilmCollection put(Film film, Actor... actors){
        collection.put(film, actors);
        return this;
    }

    public FilmCollection deleteFilm(Film film){
        collection.remove(film);
        return this;
    }

    public void serialize(File file) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(file));
        outputStream.writeObject(this);
        outputStream.close();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Film film : this.collection.keySet()) {
            builder.append(film).append(": ");
            for (Actor actor: this.collection.get(film)) {
                builder.append(actor).append("; ");
            }
            builder.replace(builder.length()-2, builder.length(), "");
            builder.append("\n");
        }

        return builder.toString();
    }
}
