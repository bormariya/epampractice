package javase04.t03;

import lombok.Getter;

import java.io.*;
import java.nio.charset.Charset;

@SuppressWarnings("unused")
public class MyFileWriter implements Closeable{
    private boolean isAppendable = true;
    private BufferedWriter bufferedWriter;
    @Getter
    private String path;
    @Getter
    private Charset charset;

    private MyFileWriter(String path, Charset charset) throws IOException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, isAppendable), charset));
        this.path = path;
        this.charset = charset;

    }

    public static MyFileWriter create(String path, Charset charset) throws IOException {
        return new MyFileWriter(path, charset);
    }

    public static MyFileWriter create(String path) throws IOException {
        return new MyFileWriter(path, Charset.forName("utf-8"));
    }

    public void writeNewData(String data) throws IOException {
        if(this.isAppendable){
            this.isAppendable = false;
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, isAppendable), charset));
        }

        bufferedWriter.write(data);
    }

    public void writeData(String data) throws IOException {
        if(!this.isAppendable){
            this.isAppendable = true;
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, isAppendable), charset));
        }

        bufferedWriter.newLine();
        bufferedWriter.write(data);
    }

    public void setFileForWriting(String path, Charset charset) throws FileNotFoundException {
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, isAppendable), charset));
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
