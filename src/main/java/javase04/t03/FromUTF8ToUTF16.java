package javase04.t03;

import java.io.IOException;
import java.nio.charset.Charset;

public class FromUTF8ToUTF16 {
    public static void main(String[] args) throws IOException {
        MyFileReader reader = MyFileReader.getInstance("one.txt", Charset.forName("utf-8"));
        System.out.println(reader.getContent());

        MyFileWriter writer = MyFileWriter.getInstance("result.txt", Charset.forName("utf-16"));
        writer.writeData(reader.getContent());

        reader.setCharset(Charset.forName("utf-16"));
        System.out.println(reader.getContent());
        reader.setCharset(Charset.forName("Shift-JIS"));
        System.out.println(reader.getContent());

        reader.close();
        writer.close();
    }
}
