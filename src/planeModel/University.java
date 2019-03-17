package planeModel;

import java.time.LocalDate;
import java.time.Month;

public class University extends Activity {
    private int startYear;
    private int endYear;

    public University (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
        this.startYear = educationPeriod.getStartDate().getYear();
        this.endYear = educationPeriod.getEndDate().getYear();
    }

    public boolean isDayOk(LocalDate date, Student student) {
        boolean checkAll = true;
        if(checkAll) checkAll = isWorkDay(date);
        if(checkAll) checkAll = isHolliDay(date);
        if(checkAll) checkAll = isStillEducate(date);
        if(checkAll) checkAll = isStudentRecruited(student);
        return checkAll;
    }

    private boolean isStillEducate(LocalDate date) {
        return (date.isAfter(LocalDate.of(startYear, Month.JANUARY, 1))
                && date.isBefore(LocalDate.of(endYear, Month.DECEMBER, 31)));
    }
}
