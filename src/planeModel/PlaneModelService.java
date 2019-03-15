package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaneModelService {

    public void workWithPlan(Student students, Plan plan, EducationPeriod educationPeriod) {
        students.practice(plan, educationPeriod);
        students.takeKnowledge(plan, educationPeriod);
    }

    public String dayOfWeek(int days) {
            DayOfWeek dayOfWeek = LocalDate.now().plusDays(days).getDayOfWeek();
            switch(dayOfWeek){
                case MONDAY: return "MONDAY\n";
                case TUESDAY: return "TUESDAY\n";
                case WEDNESDAY: return "WEDNESDAY\n";
                case THURSDAY: return "THURSDAY\n";
                case FRIDAY: return "FRIDAY\n";
                case SATURDAY: return "SATURDAY\n";
                default: return "SUNDAY\n";
            }
    }
}
