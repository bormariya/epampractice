package javase04.t01;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaWriter implements Closeable{

    private static JavaWriter instance;
    private FileOutputStream outFile;

    private JavaWriter(String path) throws IOException {
        outFile = new FileOutputStream(path);
    }

    public static JavaWriter getInstance(String path) throws IOException {
        if(instance == null)
            instance = new JavaWriter(path);

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
