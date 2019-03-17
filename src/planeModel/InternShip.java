package planeModel;

import java.time.LocalDate;

public class InternShip extends Activity {

    public InternShip (String name, int practicePerDay, int theoryPerDay, EducationPeriod educationPeriod) {
        setName(name);
        setPracticePerDay(practicePerDay);
        setTheoryPerDay(theoryPerDay);
        setEducationPeriod(educationPeriod);
    }

    public boolean isDayOk(LocalDate date, Student student) {
        boolean checkAll = true;
        if(checkAll) checkAll = isWorkDay(date);
        if(checkAll) checkAll = isActivityStillActual(date);
        if(checkAll) checkAll = isLearningRateEnough(student);
        if(checkAll) checkAll = isStudentRecruited(student);
        return checkAll;
    }

    private boolean isLearningRateEnough(Student student) {
        return (student.getLearningRate()>= 0.5);
    }
}
