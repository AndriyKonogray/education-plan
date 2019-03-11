package planeModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaneModelService {
    private Student student;
    private List<Organization> organizations;
    private String resultMessage;
    private int days;

    public void createStudent(Student student) {
        this.student = new Student(student.getName(), student.getLearningRate(), student.getStudentsStuff());
        organizations = new ArrayList<>();
    }

    public void createStudent() {
        this.student = new Student();
        organizations = new ArrayList<>();
    }

    public void addOrganization(Organization organization) {
        if(student == null) createStudent();
        organizations.add(organization);
    }

    public Student educationEnd() {
        this.student.setOrganizations(organizations);
        Student celebrationsStudent = this.student;
        student = null;
        return celebrationsStudent;
    }

    public void addStudentInToOrganizationRecruitedList(Organization organization) {
        organization.addStudent(this.student);
    }

    public void createPlan(int totalDay) {
        this.student.setOrganizations(organizations);
        resultMessage = "";
        for(days = 0; days < totalDay; days++) {
            resultMessage += dayOfWeek(days);
            organizations.forEach(o ->
                    resultMessage += o.createPlan(student, days));
            resultMessage += "\n";
        }
    }

    public String dayOfWeek(int days) {
            DayOfWeek dayOfWeek = LocalDate.now().plusDays(days).getDayOfWeek();
            switch(dayOfWeek){
                case MONDAY: return "MONDAY\n";
                case TUESDAY: return "TUESDAY\n";
                case WEDNESDAY: return "WEDNESDAY\n";
                case THURSDAY: return "THURSDAY\n";
                case FRIDAY: return "FRIDAY\n";
                case SATURDAY: return "SATURDAY\n";
                default: return "SUNDAY\n";
            }
    }

    public String getPlane() {
        return resultMessage;
    }
}
