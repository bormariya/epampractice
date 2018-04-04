package javase04.t03;

import lombok.Getter;

import java.io.*;
import java.nio.charset.Charset;

@SuppressWarnings("unused")
public class MyFileReader implements  Closeable{
    private BufferedReader bufferedReader;
    @Getter
    private String path;
    @Getter
    private Charset charset;

    private MyFileReader(String path, Charset charset) throws IOException {
        bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), charset));
        this.path = path;
        this.charset = charset;

    }

    public static MyFileReader create(String path, Charset charset) throws IOException {
        return new MyFileReader(path, charset);
    }

    public static MyFileReader create(String path) throws IOException {
        return new MyFileReader(path, Charset.forName("utf-8"));
    }

    public String getContent() throws IOException {
        bufferedReader.lines();
        StringBuilder builder = new StringBuilder();
        String line = bufferedReader.readLine();
        while(line != null){
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }

        return builder.toString();
    }

    public void setFileForReading(String path, Charset charset) throws FileNotFoundException {
        bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), charset));

    }

    public void setFileForReading(String path) throws FileNotFoundException {
        bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), this.charset));

    }

    public void setCharset(Charset charset) throws FileNotFoundException {
        bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(this.path), charset));

    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
