package javase04.t01;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaByteWriter implements Closeable{

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

    public void writeDataToFile(String data) throws IOException {
        for(char c : data.toCharArray()){
            outFile.write(c);
        }
    }


    @Override
    public void close() throws IOException {
        outFile.close();
    }
}
