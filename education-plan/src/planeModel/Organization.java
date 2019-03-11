package planeModel;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private EducationPeriod educationPeriod;
    private String name;
    final int theoryPerDay;
    final int practicePerDay;
    final int discussionPerDay;
    private List<Student> recruitedStudents = new ArrayList<>();
    OrganizationType organizationType;

    public Organization(String name, OrganizationType organizationType, EducationPeriod educationPeriod,
                        int theoryPerDay, int practicePerDay, int discussionPerDay) {
        this.theoryPerDay = theoryPerDay;
        this.practicePerDay = practicePerDay;
        this.discussionPerDay = discussionPerDay;
        this.educationPeriod = educationPeriod;
        this.organizationType = organizationType;
        this.name = name;
    }

    public Organization(OrganizationType organizationType, EducationPeriod educationPeriod, int theoryPerDay,
                        int practicePerDay, int discussionPerDay) {
        this(null, organizationType, educationPeriod, theoryPerDay, practicePerDay, discussionPerDay);
    }

    public int getDays(Student student) {
        if(isRecruited(student)) return organizationType.getDays(educationPeriod);
        else return 0;
    }

    private boolean isRecruited(Student student) {
        for(Student s : recruitedStudents)
            if(student.equals(s)) return true;
        return false;
    }

    public void addStudent(Student student) {
        if(student.getLearningRate() > 0.4)
        recruitedStudents.add(student);
    }

    public String createPlan(Student student, int i) {
        if(isRecruited(student)) return organizationType.apply(educationPeriod, i, practicePerDay,
                theoryPerDay, discussionPerDay);
        else return "";
    }
}
