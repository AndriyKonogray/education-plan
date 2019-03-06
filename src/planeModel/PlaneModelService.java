package planeModel;

public class PlaneModelService {
    private Student student;

    public void createStudent(){
        student = new Student();
    }

    public void addOrganization(Organization organization){
        if(student != null) createStudent();
        student.addOrganization(organization);
    }

    public Student educationEnd(){
        Student celebrationsStudent = student;
        student = null;
        return celebrationsStudent;
    }
}
