package planeModel;

import java.util.List;

public class Pacifist implements Plan {

    @Override
    public void apply(Student student) {
        student.setRealExperience(calculateExp(student));
    }

    public int calculateExp(Student student) {
        List<Organization> organizations = student.getOrganizations();
            double takeExp = 0;
            if (organizations.size() != 0) {
                for (Organization o : organizations) {
                    switch (category) {
                        case PRACTICE:
                            takeExp = o.getPracticePerDay() + selfExperience;
                            break;
                        case DISCUSSION:
                            takeExp = o.getDiscussionPerDay() + selfExperience;
                            break;
                        case THEORETICAL:
                        default:
                            takeExp = o.getTheoryPerDay() * student.learningRate + selfExperience;
                            break;
                    }
                }
            }
            return (int) takeExp;
        }
}
