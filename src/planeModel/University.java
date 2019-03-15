package planeModel;

import java.time.LocalDate;

public class University extends Organization {
    private int startYear;
    private int endYear;

    public University (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
        this.startYear = educationPeriod.getStartDate().getYear();
        this.endYear = educationPeriod.getEndDate().getYear();
        setOnlyWorkDay(true);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        boolean answer = false;
        getRecruitedStudents().forEach(s -> {
            //if(s )
        });
        return true;
    }
}
