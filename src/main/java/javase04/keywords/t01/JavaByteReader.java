package javase04.keywords.t01;

import javase04.keywords.KeyWordsReader;

import java.io.*;

public class JavaByteReader extends KeyWordsReader implements Closeable{
    private static JavaByteReader instance;
    private FileInputStream fileStream;

    private JavaByteReader(String path) throws FileNotFoundException {
        fileStream = new FileInputStream(path);
    }

    public static JavaByteReader getInstance(String path) throws FileNotFoundException {
        if(instance == null)
            instance = new JavaByteReader(path);

        return instance;
    }

    @Override
    public void setFileForReading(String path) throws IOException {
        fileStream = new FileInputStream(path);
        keyWords = null; wordsCount = null;
        parsingProcess();
    }

    @Override
    protected String getContent() throws IOException {
        byte[] bb = new byte[fileStream.available()];
        //noinspection ResultOfMethodCallIgnored
        fileStream.read(bb);

        return new String(bb);
    }

    @Override
    public void close() throws IOException {
        fileStream.close();
    }
}
