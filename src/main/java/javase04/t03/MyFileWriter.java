package javase04.t03;

import lombok.Getter;

import java.io.*;
import java.nio.charset.Charset;

@SuppressWarnings("unused")
public class MyFileWriter implements Closeable{
    private static MyFileWriter instance;
    private BufferedWriter bufferedWriter;
    @Getter
    private String path;
    @Getter
    private Charset charset;

    private MyFileWriter(String path, Charset charset) throws IOException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), charset));
        this.path = path;
        this.charset = charset;

    }

    public static MyFileWriter getInstance(String path, Charset charset) throws IOException {
        if (instance == null)
            instance = new MyFileWriter(path, charset);

        return instance;
    }

    public void writeData(String data) throws IOException {
        bufferedWriter.write(data);
    }

    public void setFileForWriting(String path, Charset charset) throws FileNotFoundException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), charset));
    }

    public void setFileForReading(String path) throws FileNotFoundException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), this.charset));
    }

    public void setCharset(Charset charset) throws FileNotFoundException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(this.path), charset));
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
    }
}
