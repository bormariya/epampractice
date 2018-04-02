package javase04.t04;

import java.io.IOException;

public class Serialize {

    public static void main(String[] args) throws IOException {
        FilmCollection filmCollection = FilmCollection.create();
        Actor gosling = new Actor("Ryan", "Gosling");
        Actor stone = new Actor("Emma", "Stone");
        Actor ford = new Actor("Harrison", "Ford");
        Actor mcConaughey = new Actor("Matthew","McConaughey");
        Actor gorbacheva = new Actor("Ирина", "Горбачева","Анатольевна");
        Actor smolyakov = new Actor("Андрей", "Смоляков","Игоревич");

        filmCollection.put(Film.init("Blade Runner"), gosling, ford);
        filmCollection.put(Film.init("La-La-Lend"), gosling, stone);
        filmCollection.put(Film.init("The Help"), stone);
        filmCollection.put(Film.init("Interstellar"), mcConaughey);
        filmCollection.put(Film.init("Аритмия"), gorbacheva);
        filmCollection.put(Film.init("Тренер"), gorbacheva, smolyakov);
        filmCollection.put(Film.init("Чемпионы"), smolyakov);

        filmCollection.serialize(Constants.SERIALIZE_FILE);
    }
}
