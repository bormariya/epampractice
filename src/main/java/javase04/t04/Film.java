package javase04.t04;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalTime;

@EqualsAndHashCode
@SuppressWarnings("unused")
public class Film implements Serializable{

    private String name;
    private LocalTime continuance;
    private Genre genre;

    private Film(String name, LocalTime time, Genre genre) {
        this.name = name;
        this.continuance = time;
        this.genre = genre;
    }

    public static Film init(String name, LocalTime time, Genre genre){
        return new Film(name, time, genre);
    }

    public static Film init(String name){
        return new Film(name, LocalTime.of(1,40,0), Genre.DRAMA);
    }

    public static Film init(String name, LocalTime time){
        return new Film(name, time, Genre.DRAMA);
    }

    public static Film init(String name, Genre genre){
        return new Film(name, LocalTime.of(1,40,0), genre);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
