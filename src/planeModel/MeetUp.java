package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class MeetUp extends Activity {
    private final DayOfWeek dayOfWeek;
    private final int timesPerMonth;
    private int actualTimes;
    private Month month;

    public MeetUp(String name, int practicePerDay, int theoryPerDay, DayOfWeek dayOfWeek, int timesPerMonth) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        this.dayOfWeek = dayOfWeek;
        this.timesPerMonth = timesPerMonth;
        actualTimes = timesPerMonth*2;
        month = LocalDate.now().getMonth();
    }

    public boolean isDayOk(LocalDate date, Student student) {
        boolean checkAll = true;
        if(checkAll) checkAll = isWorkDay(date);
        if(checkAll) checkAll = isMeetUpActual(date);
        if(checkAll && isItsPractice()) checkAll = isStudentTakeNotebook(student);
        return checkAll;
    }

    private boolean isStudentTakeNotebook(Student student) {
            return student.getStudentsStuff().getNotebook();
    }

    private boolean isMeetUpActual(LocalDate date) {
        if(date.getMonth().equals(month) && actualTimes > 0 && dayOfWeek.equals(date.getDayOfWeek())) {
            actualTimes--;
            if(actualTimes == 0) {
                month = month.plus(1);
                actualTimes = timesPerMonth*2;
            }
            return true;
        }
        else return false;
    }
}
