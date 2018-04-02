package javase04.t04;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Serialize.main(new String[]{});

        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(Constants.SERIALIZE_FILE));
        FilmCollection filmCollection = (FilmCollection)inputStream.readObject();
        System.out.println(filmCollection);

        filmCollection.put(Film.init("RocknRolla"), new Actor("Tom", "Hardy"));
        System.out.printf("Modified collection: %n%s", filmCollection);

    }
}
