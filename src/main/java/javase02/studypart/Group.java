package javase02.studypart;

public class Group {
    private String name;
    private Discipline discipline;
    private Student[] students;

    Group(Discipline discipline, String name, Student... students){
        this.discipline = discipline;
        this.name = name;
        this.students = students;
    }
    public Student[] getListOfStudents(){
        return this.students;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.discipline;
    }
}
