package javase02.studypart;

import java.util.ArrayList;
import java.util.Map;

public class GroupUtils {

    public static Group[] getGroupsByStudent(Student student){
        ArrayList<Group> groups = Group.getAllGroups();
        for (Group group : groups) {
            if(!group.hasStudent(student))
                groups.remove(group);
        }

        Group[] a = new Group[groups.size()];
        groups.toArray(a);
        return a;
    }

    public static Map<Discipline, Number> getMarksByStudent(Student student){
        Group[] listOfStudentGroup = GroupUtils.getGroupsByStudent(student);
        return student.getMarks(listOfStudentGroup);
    }
}
