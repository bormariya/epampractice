package javase04.keywords;

import java.io.IOException;

public abstract class KeyWordsWriter {
    public abstract void writeDataToFile(String data) throws IOException;

    public abstract void setFileForWriting(String path) throws IOException;
}
