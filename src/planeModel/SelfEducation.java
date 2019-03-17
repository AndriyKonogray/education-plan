package planeModel;

import java.time.LocalDate;

public class SelfEducation extends Activity {

    public SelfEducation (String name, int practicePerDay, int theoryPerDay) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        return true;
    }
}
