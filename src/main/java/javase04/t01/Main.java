package javase04.t01;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JavaByteReader javaByteReader = JavaByteReader
                .getInstance("src\\main\\java\\javase03\\t03\\FileController.java");
        System.out.println("Java key words in file:\n" + javaByteReader.getKeyWords());
        System.out.println("Total count of java key words = " + javaByteReader.getWordsCount());
        System.out.println("Number of unique java key words = " + javaByteReader.getUniqueWordsCount());
        javaByteReader.close();

        JavaByteWriter javaByteWriter = JavaByteWriter.getInstance("KeyWords_result.txt");
        javaByteWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaByteReader.getKeyWords()));
        javaByteWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaByteReader.getWordsCount()));
        javaByteWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaByteReader.getUniqueWordsCount()));
        javaByteWriter.close();
    }
}
