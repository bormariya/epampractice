package javase02.studypart;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String lastName;
    private String name;
    private String middleName;
    private Integer id;

    private Map<Discipline, Number> marks;

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

    public void setMark(Discipline discipline, Number mark){
            if(discipline.isIntegerMark() && mark instanceof Integer ||
                    !discipline.isIntegerMark() && mark instanceof Double)
                this.marks.put(discipline, mark);
            else throw new NumberFormatException("Mark of " + discipline + " should be in " +
                    (discipline.isIntegerMark() ? "'Integer' " : "'Double' ") + "format");
    }

    public void setMarks(Map<Discipline, Number> marks) {
        for (Discipline discipline : marks.keySet()) {
            this.setMark(discipline, marks.get(discipline));
        }
    }

    public void setMark(Group group, Number mark){
        this.setMark(group.getDiscipline(), mark);
    }

    private HashMap<Discipline, Number> getMarks(Discipline... disciplines) {
        HashMap<Discipline, Number> marksByTheDiscipline = new HashMap<>();
        for(Discipline discipline : disciplines) {
            if(this.marks.containsKey(discipline))
                marksByTheDiscipline.put(discipline, this.marks.get(discipline));
        }
        return marksByTheDiscipline;
    }

    public HashMap<Discipline, Number> getMarks(Group... groups) {
        Discipline[] disciplines = new Discipline[groups.length];
        for (int i = 0; i < groups.length; i++){
            disciplines[i] = groups[i].getDiscipline();
        }

        return this.getMarks(disciplines);
    }
}
