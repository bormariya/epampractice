package javase04.t01;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JavaReader javaReader = JavaReader
                .getInstance("src\\main\\java\\javase03\\t03\\FileController.java");
        System.out.println("Java key words in file:\n" + javaReader.getKeyWords());
        System.out.println("Total count of java key words = " + javaReader.getWordsCount());
        System.out.println("Number of unique java key words = " + javaReader.getUniqueWordsCount());
        javaReader.close();

        JavaWriter javaWriter = JavaWriter.getInstance("KeyWords_result.txt");
        javaWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaReader.getKeyWords()));
        javaWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaReader.getWordsCount()));
        javaWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaReader.getUniqueWordsCount()));
        javaWriter.close();
    }
}
