package planeModel;

import java.time.LocalDate;

public class Meeting extends Activity {
    private LocalDate date;

    public Meeting (String name, int practicePerDay, int theoryPerDay, LocalDate date) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        this.date = date;
    }

    public boolean isDayOk(LocalDate date, Student student) {
        boolean checkAll = true;
        if(checkAll) checkAll = isMeetingDay(date);
        return checkAll;
    }

    private boolean isMeetingDay(LocalDate date) {
        return this.date.equals(date);
    }
}
