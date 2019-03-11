package planeModel;

public interface OrganizationType {
    int getDays(EducationPeriod educationPeriod);

    String apply(EducationPeriod educationPeriod, int amount, int practicePerDay,
                 int theoryPerDay, int discussionPerDay);
}
