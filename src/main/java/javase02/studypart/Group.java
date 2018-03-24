package javase02.studypart;

import lombok.EqualsAndHashCode;

import java.util.*;

@EqualsAndHashCode
public class Group {
    private Integer number;
    private String name;
    private Discipline discipline;
    private Set<Student> students;

    private static Set<Group> allGroups = new HashSet<>();

    Group(Integer number, Discipline discipline, String name, Student... students){
        this.number = number;
        this.discipline = discipline;
        this.name = name;

        this.students = new HashSet<>();
        this.students.addAll(Arrays.asList(students));

        allGroups.add(this);
    }

    public static Set<Group> getAllGroups(){
        return allGroups;
    }

    public Group setMark(Student student, Number mark){
        if(this.hasStudent(student))
            student.setMark(this.getDiscipline(), mark);

        return this;
    }

    public Group setMarks(Student student, Number... marks){
        if(this.hasStudent(student))
            for(Number mark : marks){
                student.setMark(this.getDiscipline(), mark);
            }

        return this;
    }

    public Group setMarks(Map<Student, ArrayList<Number>> marks){
        for (Student student : marks.keySet()) {
            if(this.hasStudent(student))
                for(Number mark : marks.get(student)){
                    student.setMark(this.getDiscipline(), mark);
                }
        }

        return this;
    }

    public boolean hasStudent(Student student){
        return students.contains(student);
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.discipline;
    }
}
