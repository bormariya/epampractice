package javase02.studypart;

import java.util.ArrayList;

public class Group {
    private String name;
    private Discipline discipline;
    private Student[] students;

    private static ArrayList<Group> allGroups = new ArrayList<>();

    Group(Discipline discipline, String name, Student... students){
        this.discipline = discipline;
        this.name = name;
        this.students = students;
        allGroups.add(this);
    }

    public static ArrayList<Group> getAllGroups(){
        return allGroups;
    }

    public boolean hasStudent(Student student){
        for (Student human : students) {
            if (human.equals(student))
                return true;
        }

        return false;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.discipline;
    }
}
