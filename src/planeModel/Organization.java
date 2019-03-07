package planeModel;

import java.time.LocalDate;

public class Organization {
    private int theoryPerDay;
    private int practicePerDay;
    private int discussionPerDay;
    private LocalDate startDate;
    private LocalDate endDate;
    private OrganizationCategory organizationCategory;
    private int workingDaysInWeek;

    public Organization(int theoryPerDay, int practicePerDay,int discussionPerDay, LocalDate startDate, LocalDate endDate) {
        this.theoryPerDay = theoryPerDay;
        this.practicePerDay = practicePerDay;
        this.discussionPerDay = discussionPerDay;
        this.startDate = startDate;
        this.endDate = endDate;
        ////hardCode
        this.organizationCategory = OrganizationCategory.UNIVERSITY;
         this.workingDaysInWeek = 5;
    }

    public int getPracticePerDay() {
        return practicePerDay;
    }

    public int getTheoryPerDay() {
        return theoryPerDay;
    }

    public int getDiscussionPerDay() {
        return discussionPerDay;
    }
}
