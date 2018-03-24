package javase02.studypart;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class GroupUtils {

    public static Group[] getGroupsByStudent(Student student){
        Set<Group> groups = new HashSet<>(Group.getAllGroups());
        Set<Group> groupsForDelete = new HashSet<>();
        for (Group group : groups) {
            if(!group.hasStudent(student))
                groupsForDelete.add(group);
        }

        groups.removeAll(groupsForDelete);
        Group[] a = new Group[groups.size()];
        groups.toArray(a);
        return a;
    }

    public static Map<Discipline, ArrayList<Number>> getMarksByStudent(Student student){
        Group[] listOfStudentGroup = GroupUtils.getGroupsByStudent(student);
        return student.getMarks(listOfStudentGroup);
    }

    public static Group getGroupByDiscipline(Discipline discipline){
        for(Group group : Group.getAllGroups()){
            if(group.getDiscipline().equals(discipline))
                return group;
        }

        return null;
    }
}
