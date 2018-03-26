package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class InformationBlock {

    private static InformationBlock instance;

    private Language language;
    private Locale locale;
    private ResourceBundle bundle;
    private final int questionNumber = 0;
    private final int question = 1;
    private final int answer = 2;

    private InformationBlock(){
        language = Language.RUSSIAN;
        locale = new Locale(language.getLanguage());
    }

    public static InformationBlock getInstance() {
        if(instance == null)
            instance = new InformationBlock();

        return instance;
    }

    private ResourceBundle getBundle() {
        if(bundle == null)
            bundle = ResourceBundle.getBundle("prop", locale);

        return bundle;
    }

    public void setLanguage(Language language) {
        this.language = language;
        this.locale = new Locale(language.getLanguage());
        this.bundle = ResourceBundle.getBundle("prop", locale);
    }

    public String getQuestions(){
        StringBuilder builder = new StringBuilder();

        Pattern p = Pattern.compile(";;; ");

        String[] array = new String[getBundle().keySet().size()];
        getBundle().keySet().toArray(array);

        for(int i = array.length - 1; i >= 0; i--){
            builder.append(p.split(getBundle().getString(array[i]))[questionNumber]).append(") ")
                   .append(p.split(getBundle().getString(array[i]))[question]).append("\n");
        }

        return builder.toString();
    }

    public String getAnswer(Integer questionNumber){

        Pattern p = Pattern.compile(";;; ");
        for(String key : getBundle().keySet()){
            Integer number = Integer.parseInt(p.split(getBundle().getString(key))[this.questionNumber]);
            if(number.equals(questionNumber))
                return questionNumber
                        + ": "
                        + p.split(getBundle().getString(key))[answer] + "\n";
        }

        return "No such question number...";
    }



}
