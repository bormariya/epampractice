package javase02.studypart;

import java.util.ArrayList;
import java.util.Map;

public class GroupUtils {

    public static Group[] searchGroupsByStudent(Student student, Group... groups){
        ArrayList<Group> listOfGroups = new ArrayList<>();
        for (Group group : groups) {
            for(Student studentOfGroup : group.getListOfStudents()){
                if(student.equals(studentOfGroup)) {
                    listOfGroups.add(group);
                    break;
                }
            }
        }

        Group[] a = new Group[listOfGroups.size()];
        listOfGroups.toArray(a);
        return a;
    }

    public static Map<Discipline, Number> getMarksByStudentGroup(Student student, Group... groups){
        Group[] listOfStudentGroup = searchGroupsByStudent(student, groups);
        return student.getMarks(listOfStudentGroup);
    }
}
