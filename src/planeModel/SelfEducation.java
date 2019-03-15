package planeModel;

import java.time.LocalDate;

public class SelfEducation extends Organization {

    public SelfEducation (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        return true;
    }
}
