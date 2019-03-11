package planeModel;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private double learningRate;
    private int theoreticalExperience;
    private int practiceExperience;
    private int discussionExperience;
    private List<Organization> organizations = new ArrayList<>();
    private Stuff studentsStuff;

    public Student(String name, double learningRate, Stuff studentsStuff) {
        this.name = name;
        this.learningRate = learningRate;
        this.studentsStuff = studentsStuff;
    }

    public Student() {
    }

    public int getTotalExperience() {
        setDiscussionExperience();
        setPracticeExperience();
        setTheoreticalExperience();
        return theoreticalExperience + practiceExperience + discussionExperience;
    }

    private int getExperience(ExperienceCategory category) {
        double takeExp = 0;
        if (this.organizations.size() != 0){
            for(Organization o : organizations) {
                switch (category) {
                    case PRACTICE:
                        takeExp += o.practicePerDay * o.getDays(this) * getStudentsStuff().getNotebook();
                        break;
                    case DISCUSSION:
                        takeExp += o.discussionPerDay * o.getDays(this);
                        break;
                    case THEORETICAL:
                    default:
                        takeExp += o.theoryPerDay * learningRate * o.getDays(this);
                        break;
                }
            }
        }
        return (int) takeExp;
    }

    public void setTheoreticalExperience() {
        theoreticalExperience += getExperience(ExperienceCategory.THEORETICAL);
    }

    public void setPracticeExperience() {
        practiceExperience += getExperience(ExperienceCategory.PRACTICE);
    }

    public void setDiscussionExperience() {
        discussionExperience += getExperience(ExperienceCategory.DISCUSSION);
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
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

    public void setStudentStuff(Stuff stuff) {
        this.studentsStuff = new Stuff(stuff.notebook, stuff.notepad, stuff.pen);
    }
}
