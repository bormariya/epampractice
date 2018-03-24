package javase02.studypart;

import com.sun.istack.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String lastName;
    private String name;
    private String middleName;
    private Integer id;


    private Map<Discipline, ArrayList<Number>> marks;

    Student(String lastName, String name, String middleName, Integer id){
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.id = id;
        this.marks = new HashMap<>();
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Student
                && this.lastName.equals(((Student)obj).lastName)
                && this.name.equals(((Student)obj).name)
                && this.middleName.equals(((Student)obj).middleName)
                && this.id.equals(((Student)obj).id));
    }

    public Student setMark(Discipline discipline, Number mark){
        if(GroupUtils.getGroupByDiscipline(discipline).hasStudent(this))
            if(discipline.isIntegerMark() && mark instanceof Integer ||
                    !discipline.isIntegerMark() && mark instanceof Double)
                if (this.marks.get(discipline) != null)
                    this.marks.get(discipline).add(mark);
                else {
                    this.marks.put(discipline, new ArrayList<Number>());
                    this.marks.get(discipline).add(mark);
                }
            else throw new NumberFormatException("Mark of " + discipline + " for student " + this.getFullName() +
                    " should be in " + (discipline.isIntegerMark() ? "'Integer' " : "'Double' ") + "format");

        return this;
    }

    public Student setMarks(Discipline discipline, Number... marks){
        if(GroupUtils.getGroupByDiscipline(discipline) != null &&
                GroupUtils.getGroupByDiscipline(discipline).hasStudent(this))
            for (Number mark : marks) {
                this.setMark(discipline, mark);
            }
        return this;
    }

    public Student setMarks(Map<Discipline, ArrayList<Number>> marks) {
        for (Discipline discipline : marks.keySet()) {
            if(GroupUtils.getGroupByDiscipline(discipline) != null &&
                    GroupUtils.getGroupByDiscipline(discipline).hasStudent(this))
                for(Number mark : marks.get(discipline)){
                    this.setMark(discipline, mark);
                }
        }

        return this;
    }

    public String getFullName(){
        return String.format("%s %s %s", this.lastName, this.name, this.middleName);
    }

    private HashMap<Discipline, ArrayList<Number>> getMarks(Discipline... disciplines) {
        HashMap<Discipline, ArrayList<Number>> marksByTheDiscipline = new HashMap<>();
        for(Discipline discipline : disciplines) {
            if(this.marks.containsKey(discipline))
                marksByTheDiscipline.put(discipline, this.marks.get(discipline));
        }
        return marksByTheDiscipline;
    }

    public HashMap<Discipline, ArrayList<Number>> getMarks(Group... groups) {
        Discipline[] disciplines = new Discipline[groups.length];
        for (int i = 0; i < groups.length; i++){
            disciplines[i] = groups[i].getDiscipline();
        }

        return this.getMarks(disciplines);
    }

    public String getMarksAsString(Group... groups){
        Map<Discipline, ArrayList<Number>> marks = this.getMarks(groups);
        StringBuilder builder = new StringBuilder();

        for(Discipline discipline : marks.keySet()){
            builder.append(discipline).append(": ");
            for(Number mark : marks.get(discipline)){
                builder.append(mark).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
