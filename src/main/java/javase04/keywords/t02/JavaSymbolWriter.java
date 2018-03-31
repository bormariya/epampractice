package javase04.keywords.t02;

import javase04.keywords.KeyWordsWriter;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

public class JavaSymbolWriter extends KeyWordsWriter implements Closeable{

    private static JavaSymbolWriter instance;
    private FileWriter outFile;

    private JavaSymbolWriter(String path) throws IOException {
        outFile = new FileWriter(path);
    }

    public static JavaSymbolWriter getInstance(String path) throws IOException {
        if(instance == null)
            instance = new JavaSymbolWriter(path);

        return instance;
    }

    @Override
    public void writeDataToFile(String data) throws IOException {
        outFile.write(data);
    }

    @Override
    public void setFileForWriting(String path) throws IOException {
        outFile = new FileWriter(path);
    }

    @Override
    public void close() throws IOException {
        outFile.close();
    }
}
