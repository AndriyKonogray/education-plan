package planeModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    private String name;
    private List<Activity> activities = new ArrayList<>();

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public int goPractice(LocalDate date, Student student, Activity activity) {
            activity.setItsPractice(true);
            if(activity.isDayOk(date, student)) return activity.getPracticePerDay();
            else return 0;
    }

    public int goTakeKnowledge(LocalDate date, Student student, Activity activity) {
        activity.setItsPractice(false);
        if(activity.isDayOk(date, student)) return activity.getTheoryPerDay();
        else return 0;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}
