package planeModel;

import java.time.LocalDate;

public class Meeting extends Organization {

    public Meeting (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        return true;
    }
}
