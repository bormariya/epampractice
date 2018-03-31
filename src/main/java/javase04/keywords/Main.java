package javase04.keywords;

import javase04.keywords.t01.JavaByteReader;
import javase04.keywords.t01.JavaByteWriter;
import javase04.keywords.t02.JavaSymbolReader;
import javase04.keywords.t02.JavaSymbolWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        callByteReaderAndWriter();
        callSymbolReaderAndWriter();
    }

    private static void callByteReaderAndWriter() throws IOException {
        JavaByteReader javaByteReader = JavaByteReader
                .getInstance("src\\main\\java\\javase03\\t03\\FileController.java");
        JavaByteWriter javaByteWriter = JavaByteWriter.getInstance("KeyWords_byte_result1.txt");
        System.out.println("1) Java key words in file:\n" + javaByteReader.getKeyWords());
        System.out.println("1) Total count of java key words = " + javaByteReader.getWordsCount());
        System.out.println("1) Number of unique java key words = " + javaByteReader.getUniqueWordsCount());

        javaByteWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaByteReader.getKeyWords()));
        javaByteWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaByteReader.getWordsCount()));
        javaByteWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaByteReader.getUniqueWordsCount()));

        javaByteReader.setFileForReading("src\\main\\java\\javase03\\t02\\InformationBlock.java");
        javaByteWriter.setFileForWriting("KeyWords_byte_result.txt2");
        System.out.println("2) Java key words in file:\n" + javaByteReader.getKeyWords());
        System.out.println("2) Total count of java key words = " + javaByteReader.getWordsCount());
        System.out.println("2) Number of unique java key words = " + javaByteReader.getUniqueWordsCount());

        javaByteWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaByteReader.getKeyWords()));
        javaByteWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaByteReader.getWordsCount()));
        javaByteWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaByteReader.getUniqueWordsCount()));

        javaByteReader.close();

        javaByteWriter.close();
    }

    private static void callSymbolReaderAndWriter() throws IOException {
        JavaSymbolReader javaSymbolReader = JavaSymbolReader
                .getInstance("src\\main\\java\\javase03\\t03\\FileController.java");
        JavaSymbolWriter javaSymbolWriter = JavaSymbolWriter.getInstance("KeyWords_symbol_result1.txt");
        System.out.println("1) Java key words in file:\n" + javaSymbolReader.getKeyWords());
        System.out.println("1) Total count of java key words = " + javaSymbolReader.getWordsCount());
        System.out.println("1) Number of unique java key words = " + javaSymbolReader.getUniqueWordsCount());

        javaSymbolWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaSymbolReader.getKeyWords()));
        javaSymbolWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaSymbolReader.getWordsCount()));
        javaSymbolWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaSymbolReader.getUniqueWordsCount()));

        javaSymbolReader.setFileForReading("src\\main\\java\\javase03\\t02\\InformationBlock.java");
        javaSymbolWriter.setFileForWriting("KeyWords_symbol_result2.txt");
        System.out.println("2) Java key words in file:\n" + javaSymbolReader.getKeyWords());
        System.out.println("2) Total count of java key words = " + javaSymbolReader.getWordsCount());
        System.out.println("2) Number of unique java key words = " + javaSymbolReader.getUniqueWordsCount());

        javaSymbolWriter.writeDataToFile(String.format("Java key words in file:%n%s", javaSymbolReader.getKeyWords()));
        javaSymbolWriter.writeDataToFile(String.format("Total count of java key words = %d%n", javaSymbolReader.getWordsCount()));
        javaSymbolWriter.writeDataToFile(String.format("Number of unique java key words = %d%n", javaSymbolReader.getUniqueWordsCount()));

        javaSymbolReader.close();
        javaSymbolWriter.close();
    }
}
