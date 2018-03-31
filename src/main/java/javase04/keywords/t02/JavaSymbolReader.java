package javase04.keywords.t02;

import javase04.keywords.KeyWordsReader;

import java.io.*;

public class JavaSymbolReader extends KeyWordsReader implements Closeable{

    private BufferedReader inFile;
    private static JavaSymbolReader instance;

    private JavaSymbolReader(String path) throws FileNotFoundException {
        inFile = new BufferedReader(new FileReader(path));
    }

    public static JavaSymbolReader getInstance(String path) throws FileNotFoundException {
        if(instance == null)
            instance = new JavaSymbolReader(path);

        return instance;
    }

    @Override
    public void close() throws IOException {
        inFile.close();
    }

    @Override
    public void setFileForReading(String path) throws IOException {
        inFile = new BufferedReader(new FileReader(path));
        keyWords = null; wordsCount = null;
        parsingProcess();

    }

    @Override
    protected String getContent() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = inFile.readLine();
        while(line != null){
            builder.append(line);
            line = inFile.readLine();
        }

        return builder.toString();
    }
}
