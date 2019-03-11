package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class MeetUp implements OrganizationType {
    private final DayOfWeek dayOfWeek;
    private final int timesPerMonth;
    private int actualTimes;
    private Month lastMonth;

    public MeetUp(DayOfWeek dayOfWeek, int timesPerMonth) {
        this.dayOfWeek = dayOfWeek;
        this.timesPerMonth = timesPerMonth;
        actualTimes = timesPerMonth;
        lastMonth = LocalDate.now().getMonth();
    }

    @Override
    public int getDays(EducationPeriod educationPeriod) {
        int allDays = 0;
        LocalDate date = LocalDate.from(educationPeriod.getStartDate());
        Month lastMonth = date.getMonth().minus(1);
        int times = 0;
        while(date.isBefore(educationPeriod.getEndDate().plusDays(1))) {
            if(times == 0 && !date.getMonth().equals(lastMonth)) {
                times = timesPerMonth;
                lastMonth = date.getMonth();
            }
            if(date.getDayOfWeek() == dayOfWeek && times > 0) {
                allDays ++;
                times --;
            }
            date = date.plusDays(1);
        }
        return allDays;
    }

    @Override
    public String apply(EducationPeriod educationPeriod, int amount, int practicePerDay,
                        int theoryPerDay, int discussionPerDay) {
        LocalDate today = LocalDate.now().plusDays(amount);
        if(today.isAfter(educationPeriod.getStartDate().minusDays(1)) &&
                today.isBefore(educationPeriod.getEndDate().plusDays(1))) {
            if(actualTimes == 0 && !today.getMonth().equals(lastMonth)) {
                actualTimes = timesPerMonth;
                lastMonth = today.getMonth();
            }
            if(today.getDayOfWeek() == dayOfWeek && actualTimes > 0) {
                actualTimes--;
                return String.format("MeetUp practice %d, theory %d\n", practicePerDay,
                        theoryPerDay + discussionPerDay);
            }
        }
        return "";
    }
}
