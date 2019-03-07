package planeModel;

import java.util.List;

public class Student {
    private String name;
    private double learningRate = 0.5;
    private int theoreticalExperience;
    private int practiceExperience;
    private int discussionExperience;
    private int selfExperience = 1;
    private UserActivity userActivity;
    private int realExperience;
    private List<Organization> organizations;

    public void addUserActivity(UserActivity userActivity) {
        this.userActivity = userActivity;
    }

    public int getTotalExperience() {
        setDiscussionExperience();
        setPracticeExperience();
        setTheoreticalExperience();
        return theoreticalExperience + practiceExperience + discussionExperience;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    private int getExperience(ExperienceCategory category) {
        double takeExp = 0;
        if (this.userActivity!= null){
            switch (category){
                case PRACTICE:
                    takeExp =  this.userActivity.practice + selfExperience;
                    break;
                case DISCUSSION:
                    takeExp = this.userActivity.discussion + selfExperience;
                    break;
                case THEORETICAL:
                default :
                    takeExp = this.userActivity.theory * learningRate + selfExperience;
                    break;
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

    public int getRealExperience() {
        return realExperience;
    }

    public void setRealExperience(int realExperience) {
        this.realExperience = realExperience;
    }
}
