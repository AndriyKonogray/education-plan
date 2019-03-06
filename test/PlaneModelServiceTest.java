import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planeModel.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlaneModelServiceTest {
    private PlaneModelService planeModelService;
    Organization CHDTU_50;

    @BeforeEach
    void setUp(){
        planeModelService  = new PlaneModelService();
        planeModelService.createStudent();
        CHDTU_50 = new Organization();
    }

    @Test
    void educationEnd_withOneOrganization(){
        planeModelService.addOrganization(CHDTU_50);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExpirience(), is(50));

    }
}
