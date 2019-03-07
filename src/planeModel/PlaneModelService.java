package planeModel;

public class PlaneModelService {
    private Student student;
    private UserActivity userActivity;

    public void createStudent() {
        student = new Student();
    }

    public void addUserActivity(UserActivity userActivity) {
        if(student == null) createStudent();
        this.userActivity = userActivity;
        student.addUserActivity(userActivity);
    }

    public Student educationEnd() {
        Student celebrationsStudent = student;
        student = null;
        return celebrationsStudent;
    }

    public void usePlan() {
        userActivity.apply(student);
    }
}
