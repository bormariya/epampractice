package javase02.studypart;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Student firstS = new Student("Иванов", "Иван", "Иванович", 43135186);
        Student secondS = new Student("Петров", "Петр", "Петрович", 43135187);

        Group ub1310 = new Group(1, Discipline.ENGLISH, "УБ13-10", firstS, secondS);
        Group ub1311 = new Group(2, Discipline.ECONOMICS, "УБ13-11", secondS);

        ub1310.setMarks(firstS, 4, 5, 4, 3); ub1310.setMarks(secondS, 5,5,5,3);
        firstS.setMark(Discipline.ENGLISH, 5); firstS.setMark(Discipline.ECONOMICS, 5);
        ub1311.setMarks(firstS, 4, 4, 5); ub1311.setMarks(secondS, 4, 4, 5);

        Group[] groupsForFirstS = GroupUtils.getGroupsByStudent(firstS);
        Group[] groupsForSecondS = GroupUtils.getGroupsByStudent(secondS);

        System.out.println(firstS.getFullName() + ": \n" + firstS.getMarksAsString(groupsForFirstS));//оценки по определенным группам
        System.out.println(secondS.getFullName() + ": \n" + secondS.getMarksAsString(groupsForSecondS));
    }
}
