package javase03.t02;

public class Main {
    public static void main(String[] args) {
        InformationBlock information = InformationBlock.getInstance();
        System.out.println(information.getQuestions());
        System.out.println(information.getAnswer(2));
        System.out.println(information.getAnswer(4));

        information.setLanguage(Language.ENGLISH);
        System.out.println(information.getQuestions());
        System.out.println(information.getAnswer(1));
        System.out.println(information.getAnswer(3));




    }
}
