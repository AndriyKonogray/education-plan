package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

abstract class Activity implements Condition {
    private String name;
    private int theoryPerDay;
    private int practicePerDay;
    private List<Student> recruitedStudents = new ArrayList<>();
    private EducationPeriod educationPeriod;
    private boolean itsPractice;

    public boolean isActivityStillActual(LocalDate date) {
        return (date.isAfter(getEducationPeriod().getStartDate().minusDays(1))
                && date.isBefore(getEducationPeriod().getEndDate().plusDays(1)));
    }

    public boolean isStudentRecruited(Student student) {
        for(Student s:getRecruitedStudents()) {
            if(student.equals(s)) return true;
        }
        return false;
    }

    public boolean isHolliDay(LocalDate date) {
        return (date.getMonth()!= Month.JANUARY && date.getMonth()!= Month.JULY && date.getMonth()!= Month.JUNE
                && date.getMonth()!= Month.AUGUST);
    }

    public static boolean isWorkDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch(dayOfWeek){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return true;
            case SATURDAY:
            default: return false;
        }
    }

    public boolean isItsPractice() {
        return itsPractice;
    }

    public void setItsPractice(boolean itsPractice) {
        this.itsPractice = itsPractice;
    }

    public EducationPeriod getEducationPeriod() {
        return educationPeriod;
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
