package javase02.studypart;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Student firstS = new Student("Иванов", "Иван", "Иванович", 43135186);
        Student secondS = new Student("Петров", "Петр", "Петрович", 43135187);

        Group ub1310 = new Group(Discipline.ENGLISH, "УБ13-10", firstS, secondS);
        Group ub1311 = new Group(Discipline.ECONOMICS, "УБ13-11", secondS);
        Group ub1312 = new Group(Discipline.JAVA, "УБ13-12", firstS, secondS);
        Group ub1317 = new Group(Discipline.ALGORITHMS, "УБ13-17", firstS, secondS);

        HashMap<Discipline, Number> forFirstS = new HashMap<>();
        forFirstS.put(Discipline.ENGLISH, 5.1); forFirstS.put(Discipline.JAVA, 4.3);

        HashMap<Discipline, Number> forSecondS = new HashMap<>();
        forSecondS.put(Discipline.ENGLISH, 4); forSecondS.put(Discipline.ECONOMICS, 5);
        forSecondS.put(Discipline.JAVA, 5); forSecondS.put(Discipline.ALGORITHMS, 5);

        firstS.setMarks(forFirstS); firstS.setMark(Discipline.ALGORITHMS, 5);
        secondS.setMarks(forSecondS);

        Group[] groupsForFirstS = GroupUtils.getGroupsByStudent(firstS);
        Group[] groupsForSecondS = GroupUtils.getGroupsByStudent(secondS);

        HashMap<Discipline, Number> marksOfFirstS = firstS.getMarks(groupsForFirstS);
        HashMap<Discipline, Number> marksOfSecondS = secondS.getMarks(groupsForSecondS);

        System.out.println(marksOfFirstS);
        System.out.println(marksOfSecondS);
    }
}
