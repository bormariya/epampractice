package javase04.keywords.t01;

import javase04.keywords.KeyWordsWriter;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaByteWriter extends KeyWordsWriter implements Closeable {

    private static JavaByteWriter instance;
    private FileOutputStream outFile;

    private JavaByteWriter(String path) throws IOException {
        outFile = new FileOutputStream(path);
    }

    public static JavaByteWriter getInstance(String path) throws IOException {
        if(instance == null)
            instance = new JavaByteWriter(path);

        return instance;
    }

    @Override
    public void writeDataToFile(String data) throws IOException {
        for(char c : data.toCharArray()){
            outFile.write(c);
        }
    }

    @Override
    public void setFileForWriting(String path) throws IOException {
        outFile = new FileOutputStream(path);
    }


    @Override
    public void close() throws IOException {
        outFile.close();
    }
}
