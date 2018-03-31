package javase04.keywords;

import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class KeyWordsReader {
    protected Integer wordsCount;
    protected HashSet<String> keyWords;

    public void setFileForReading(String path) throws IOException {}

    public String getKeyWords() throws IOException {
        parsingProcess();
        return keyWords.toString()
                .replaceAll("[\\[\\]]","")
                .replaceAll(", ", "\n") + "\n";
    }

    public int getWordsCount() throws IOException {
        parsingProcess();
        return wordsCount;
    }

    public int getUniqueWordsCount() throws IOException {
        parsingProcess();
        return keyWords.size();
    }

    protected void parsingProcess() throws IOException {
        if (wordsCount == null || keyWords == null) {
            StringBuilder builder = new StringBuilder();
            for (KeyWords word : KeyWords.values()) {
                builder.append(word.toString().toLowerCase()).append("|");
            }

            Pattern p = Pattern.compile(builder.substring(0, builder.length() - 1));
            Matcher m = p.matcher(this.getContent());

            wordsCount = 0;
            keyWords = new HashSet<>();
            while (m.find()) {
                wordsCount++;
                keyWords.add(m.group());
            }
        }

    }

    protected abstract String getContent() throws IOException;
}
