package javase03.t01;

public class Main {
    public static void main(String[] args) {
        CrazyLogger logger = CrazyLogger.getInstance();

        Integer a = 10;
        logger.addMessage("A variable a was created and it equals " + a);
        Boolean b = false;
        logger.addMessage("Then variable b, which is boolean, was created as " + b);
        String s = "'some string'";
        b = true;
        logger.addMessage("Finally here variable s was creating as String and equals " + s)
                .addMessage("And here is the boolean variable again. It is b = " + b);

        String phrase = "boolean";
        System.out.println((logger.contains(phrase) ? "Here is a " : "No ")
                                + "line with the phrase \""
                                + phrase + "\"");
        if(logger.contains(phrase))
            System.out.println("The line with the phrase \"" + phrase + "\":\n"
                    +"---"+logger.searchWithPhrase(phrase));
    }
}
