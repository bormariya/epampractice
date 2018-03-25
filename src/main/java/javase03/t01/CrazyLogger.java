package javase03.t01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {

    private static CrazyLogger instance;

    private StringBuilder messages;

    private CrazyLogger(){
        messages = new StringBuilder();
    }

    public static CrazyLogger getInstance(){
        if (instance == null) {
            instance = new CrazyLogger();
        }

        return instance;
    }

    public CrazyLogger addMessage(String message){
        StringBuilder builder = new StringBuilder(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm")))
                .append(" - ")
                .append(message)
                .append("\n");
        System.out.print(builder);
        messages.append(builder);
        return this;
    }

    public boolean contains(String phrase){
        return messages.indexOf(phrase) != -1;
    }

    public String searchWithPhrase(String phrase){
        StringBuilder builder = new StringBuilder();
        if(this.contains(phrase)) {
            Matcher m = Pattern.compile("\n.*"+phrase+".*\n").matcher(messages);
            while (m.find())
                builder.append(m.group());
        }

        return builder.toString();
    }
}
