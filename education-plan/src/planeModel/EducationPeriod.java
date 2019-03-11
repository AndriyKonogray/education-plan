package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EducationPeriod {
    private LocalDate startDate;
    private LocalDate endDate;

    public EducationPeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EducationPeriod(LocalDate startDate) {
        this(startDate, startDate);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public static boolean isWorkDay(LocalDate day) {
            DayOfWeek dayOfWeek = day.getDayOfWeek();
            switch(dayOfWeek){
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                    return true;
                case SATURDAY:
                default: return false;
            }
    }

    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }
}
