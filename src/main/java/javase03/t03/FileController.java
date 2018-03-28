package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileController {

    private static FileController instance;
    private File fileForChecking;

    private FileController(String filePath){
        this.fileForChecking = new File(filePath);
    }

    public static FileController getInstance(String filePath) {
        if(instance == null)
            instance = new FileController(filePath);

        return instance;
    }

    public boolean isConsistent() throws IOException {
        String content = this.getContent(fileForChecking);

        Pattern p = Pattern.compile("\\([Рр]ис[.]\\s*(\\d*)");
        Matcher m = p.matcher(content);
        ArrayList<Integer> array = new ArrayList<>();
        while(m.find()){
                array.add(Integer.parseInt(m.group(1)));
        }

        for (int i = 1; i < array.size(); i++){
            if(array.get(i) < array.get(i-1))
                return false;
        }

        return true;
    }

    private String getContent(File file) throws IOException {
        char[] CB = new char[(int) file.length()];
        Reader reader = new InputStreamReader(new FileInputStream(file), "cp1251");
        reader.read(CB);
        reader.close();
        StringBuilder content = new StringBuilder();

        for(char c : CB){
            content.append(c);
        }

        return content.toString();
    }

    public String getCoincidences() throws IOException {
        String content = this.getContent(fileForChecking);

        Pattern p = Pattern.compile("\\. [А-Я].*\\([Рр]ис[.]\\s*(\\d*)[^.]*[.]");
        Matcher m = p.matcher(content);

        StringBuilder builder = new StringBuilder();
        while(m.find()){
            builder
                    .append(m.group()
                            .replaceFirst(". ", "")
                            .replaceAll("<.*>", ""))
                    .append("\n");
        }

        return builder.toString();
    }
}
