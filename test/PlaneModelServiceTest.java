import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planeModel.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlaneModelServiceTest {
    private PlaneModelService planeModelService;
    UserActivity Pacifist_theory8_practice2_discussion1;

    @BeforeEach
    void setUp(){
        planeModelService  = new PlaneModelService();
        planeModelService.createStudent();
        Pacifist_theory8_practice2_discussion1 = new UserActivity(new Pacifist(), null,8,2,1);


    }

    @Test
    void educationEnd_withOneUserActivityForOneDay() {
        //selfExperience = 1 / learningRate = 0.5
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(10));
    }

    /*@Test
    void educationEnd_withTwoUserActivity() {
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(20));
    }
*/
    @Test
    void addUserActivity__whenEducationIsEnded__createdNewStudent() {
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(10));
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(10));
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(10));
    }

    @Test
    void usePlan__ForPacifistOnly__addStudentRealPoint() {
        planeModelService.addUserActivity(Pacifist_theory8_practice2_discussion1);
        planeModelService.usePlan();
        Student student = planeModelService.educationEnd();
        assertThat(student.getRealExperience(), is(4));
    }
}
