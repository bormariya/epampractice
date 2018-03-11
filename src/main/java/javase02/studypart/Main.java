package javase02.studypart;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Student firstS = new Student("Иванов", "Иван", "Иванович", 43135186);
        Student secondS = new Student("Петров", "Петр", "Петрович", 43135187);
        Student thirdS = new Student("Сидоров", "Сидор", "Сидорович", 43135188);
        Student fourthS = new Student("Николаев", "Николай", "Николаевич", 43135189);
        Student fifthS = new Student("Евгеньев", "Евгений", "Евгеньевич", 43135190);

        Discipline eng = new Discipline("Английский", false);
        Discipline economy = new Discipline("Экономика");
        Discipline java = new Discipline("Java", false);
        Discipline eco = new Discipline("Экология");

        Group ub1310 = new Group(eng, "УБ13-10", firstS, secondS, thirdS, fourthS, fifthS);
        Group ub1311 = new Group(economy, "УБ13-11", secondS, thirdS, fourthS, fifthS);
        Group ub1312 = new Group(java, "УБ13-12", firstS, secondS, thirdS, fourthS);
        Group ub1317 = new Group(eco, "УБ13-17", firstS, secondS, fourthS, fifthS);

        firstS.setMark(eng, 5.0); firstS.setMark(java, 4.3); firstS.setMark(eco, 5);
        secondS.setMark(eng, 4.0); secondS.setMark(economy, 5); secondS.setMark(java, 4.3); secondS.setMark(eco, 5);
        thirdS.setMark(eng, 4.5); thirdS.setMark(economy, 3); thirdS.setMark(java, 5.0);
        fourthS.setMark(eng, 4.0); fourthS.setMark(economy, 5); fourthS.setMark(java, 4.3); fourthS.setMark(eco, 5);
        fifthS.setMark(eng, 5.0); fifthS.setMark(economy, 5); fifthS.setMark(eco, 4);

        Group[] groupsForFirstS = GroupUtils.searchGroupsByStudent(firstS, ub1310, ub1311, ub1312, ub1317);
        Group[] groupsForSecondS = GroupUtils.searchGroupsByStudent(secondS, ub1310, ub1311, ub1312, ub1317);
        Group[] groupsForThirdS = GroupUtils.searchGroupsByStudent(thirdS, ub1310, ub1311, ub1312, ub1317);
        Group[] groupsForFourthS = GroupUtils.searchGroupsByStudent(fourthS, ub1310, ub1311, ub1312, ub1317);
        Group[] groupsForFifthS = GroupUtils.searchGroupsByStudent(fifthS, ub1310, ub1311, ub1312, ub1317);

        HashMap<Discipline, Number> marksOfFirstS = firstS.getMarks(groupsForFirstS);
        HashMap<Discipline, Number> marksOfSecondS = secondS.getMarks(groupsForSecondS);
        HashMap<Discipline, Number> marksOfThirdS = thirdS.getMarks(groupsForThirdS);
        HashMap<Discipline, Number> marksOfFourthS = fourthS.getMarks(groupsForFourthS);
        HashMap<Discipline, Number> marksOfFifthS = fifthS.getMarks(groupsForFifthS);

        System.out.println(marksOfFirstS);
        System.out.println(marksOfSecondS);
        System.out.println(marksOfThirdS);
        System.out.println(marksOfFourthS);
        System.out.println(marksOfFifthS);




    }
}
