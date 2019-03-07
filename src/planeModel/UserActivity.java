package planeModel;

import java.time.LocalDate;

public class UserActivity {
    private String name;
    private OrganizationCategory organizationCategory;
    Condition condition;
    Plan plan;
    final int theory;
    final int practice;
    final int discussion;
    LocalDate PlanEndDate = LocalDate.now().plusYears(5);

    public UserActivity(Plan plan, Condition condition, int theory, int practice, int discussion) {
        this.plan = plan;
        this.condition = condition;
        this.theory = theory;
        this.practice = practice;
        this.discussion = discussion;
    }

    public UserActivity(int theory, int practice, int discussion) {
            this(null, null,
                    theory, practice, discussion);
    }

    public void apply(Student student) {
        plan.apply(student);
    }
}
