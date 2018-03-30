package javase04.t01;

import java.io.*;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaByteReader implements Closeable{
    private static JavaByteReader instance;
    private FileInputStream fileStream;
    private Integer wordsCount;
    private HashSet<String> keyWords;

    private JavaByteReader(String path) throws FileNotFoundException {
        fileStream = new FileInputStream(path);
    }

    public static JavaByteReader getInstance(String path) throws FileNotFoundException {
        if(instance == null)
            instance = new JavaByteReader(path);

        return instance;
    }

    public String getKeyWords() throws IOException {
        if(keyWords == null)
            parsingProcess();

        return keyWords.toString()
                .replaceAll("[\\[\\]]","")
                .replaceAll(", ", "\n") + "\n";
    }

    public int getWordsCount() throws IOException {
        if(wordsCount == null)
            parsingProcess();

        return wordsCount;
    }

    public int getUniqueWordsCount() throws IOException {
        if(keyWords == null)
            parsingProcess();

        return keyWords.size();
    }

    private void parsingProcess() throws IOException {
        StringBuilder builder = new StringBuilder();
        for(KeyWords word : KeyWords.values()){
            builder.append(word.toString().toLowerCase()).append("|");
        }

        Pattern p = Pattern.compile(builder.substring(0, builder.length()-1));
        Matcher m = p.matcher(this.getContent());

        wordsCount = 0;
        keyWords = new HashSet<>();
        while(m.find()) {
            wordsCount++;
            keyWords.add(m.group());
        }
    }

    private String getContent() throws IOException {
        byte[] cb = new byte[fileStream.available()];
        //noinspection ResultOfMethodCallIgnored
        fileStream.read(cb);
        StringBuilder builder = new StringBuilder();
        for (byte b : cb) {
            builder.append((char)b);
        }
        return builder.toString();
    }

    @Override
    public void close() throws IOException {
        fileStream.close();
    }
}
