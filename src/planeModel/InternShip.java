package planeModel;

import java.time.LocalDate;

public class InternShip extends Organization {

    public InternShip (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
        setOnlyWorkDay(true);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        return true;
    }
}
