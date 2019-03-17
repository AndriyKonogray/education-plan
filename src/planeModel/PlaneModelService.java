package planeModel;

import java.util.List;

public class PlaneModelService {

    public void workWithPlan(List<Student> students, Plan plan, EducationPeriod educationPeriod) {
        students.forEach(student -> student.practiceAndTakeKnowledge(plan, educationPeriod));
    }

    public void recruited(Student students, Plan plan, String name) {
        plan.getActivities().forEach(activity -> {
            if(activity.getName().equals(name)) activity.getRecruitedStudents().add(students);
        });
    }
}
