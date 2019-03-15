package planeModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    private String name;
    private Condition condition;
    private List<Organization> organizations = new ArrayList<>();
    private int result;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int goPractice(EducationPeriod educationPeriod, Student student) {
        result = 0;
        organizations.forEach(o -> {
            condition = o;
            result = o.getPracticePerDay()*getDays(educationPeriod, student);
        });
       return result;
    }

    public int getDays(EducationPeriod educationPeriod, Student student) {
        int allDays = 0;
        LocalDate date = LocalDate.from(educationPeriod.getStartDate());
        while(date.isBefore(educationPeriod.getEndDate().plusDays(1))) {
            if(condition.isDayOk(date, student)) allDays ++;
            date = date.plusDays(1);
        }
        return allDays;
    }

    public int goTakeKnowledge(EducationPeriod educationPeriod, Student student) {
        result = 0;
        organizations.forEach(o -> {
            condition = o;
            result = o.getTheoryPerDay()*getDays(educationPeriod, student);
        });
        return result;
    }

    public void addOrganization(Organization organization) {
        organizations.add(organization);
    }
}
