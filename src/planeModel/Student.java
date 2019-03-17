package planeModel;

import java.time.LocalDate;

public class Student {
    private String name;
    private double learningRate;
    private Stuff studentsStuff;
    private double practiceExperience;
    private double knowledge;
    private LocalDate activityDate;

    public Student(String name, double learningRate, Stuff studentsStuff) {
        this.name = name;
        this.learningRate = learningRate;
        this.studentsStuff = studentsStuff;
        practiceExperience = 0;
        knowledge = 0;
    }

    public Student() {
    }

    public  int getKnowledge() {
        return (int)knowledge;
    }

    public void practiceAndTakeKnowledge(Plan plan, EducationPeriod educationPeriod) {
        activityDate = LocalDate.from(educationPeriod.getStartDate());
        while(activityDate.isBefore(educationPeriod.getEndDate().plusDays(1))) {
            plan.getActivities().forEach(activity -> {
                setPracticeExperience(plan.goPractice(activityDate, this, activity));
                setKnowledge((plan.goTakeKnowledge(activityDate, this, activity)*getLearningRate()));
            });
            activityDate = activityDate.plusDays(1);
        }
    }

    public int getPracticeExperience() {
        return (int)practiceExperience;
    }

    private void setPracticeExperience(double practiceExperience) {
        this.practiceExperience += practiceExperience;
    }

    private void setKnowledge(double knowledge) {
        this.knowledge += knowledge;
    }

    public String getName() {
        return name;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public Stuff getStudentsStuff() {
        return studentsStuff;
    }
}
