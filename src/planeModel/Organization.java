package planeModel;

import java.util.ArrayList;
import java.util.List;

abstract class Organization implements Condition {
    private String name;
    private int theoryPerDay;
    private int practicePerDay;
    private List<Student> recruitedStudents = new ArrayList<>();
    private boolean onlyWorkDay = false;
    private EducationPeriod educationPeriod;

    public void setOnlyWorkDay(boolean onlyWorkDay) {
        this.onlyWorkDay = onlyWorkDay;
    }

    public void setRecruitedStudents(List<Student> recruitedStudents) {
        this.recruitedStudents = recruitedStudents;
    }

    public int getTheoryPerDay() {
        return theoryPerDay;
    }

    public int getPracticePerDay() {
        return practicePerDay;
    }

    public List<Student> getRecruitedStudents() {
        return recruitedStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPracticePerDay(int practicePerDay) {
        this.practicePerDay = practicePerDay;
    }

    public void setTheoryPerDay(int theoryPerDay) {
        this.theoryPerDay = theoryPerDay;
    }

    public void setEducationPeriod(EducationPeriod educationPeriod) {
        this.educationPeriod = educationPeriod;
    }
}
