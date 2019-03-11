import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planeModel.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlaneModelServiceTest {
    private PlaneModelService planeModelService;
    Organization Organization_Theory8_practice2_discussion1;
    Student testStudent_rate05_selfExp1;
    Organization SelfEducation_Theory2_practice1_discussion1;
    Organization UniversityTest_7days_res15;
    OrganizationType organizationType;
    EducationPeriod educationPeriod;

    @BeforeEach
    void setUp() {
        Stuff stuff = new Stuff(true, true, true);
        planeModelService  = new PlaneModelService();
        testStudent_rate05_selfExp1 = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(testStudent_rate05_selfExp1);
        EducationPeriod educationPeriod_1Days = new EducationPeriod(LocalDate.now(), LocalDate.now());
        organizationType = new SelfEducation();
        Organization_Theory8_practice2_discussion1 = new Organization(organizationType, educationPeriod_1Days, 8,
                2,1);
        EducationPeriod educationPeriod_2Days = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(1));
        SelfEducation_Theory2_practice1_discussion1 = new Organization(organizationType, educationPeriod_2Days, 2,
                1, 1);
        organizationType = new University();
        EducationPeriod educationPeriod_7Days = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(6));
        UniversityTest_7days_res15 = new Organization(organizationType, educationPeriod_7Days,
                2, 1, 1);
    }

    @Test
    void educationEnd__withOneOrganizationForOneDay() {
        planeModelService.addOrganization(Organization_Theory8_practice2_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(Organization_Theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(7));
    }

    @Test
    void educationEnd__withTwoOrganizationsForOneDay() {
        planeModelService.addOrganization(Organization_Theory8_practice2_discussion1);
        planeModelService.addOrganization(Organization_Theory8_practice2_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(Organization_Theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(14));
    }

    @Test
    void addOrganization__whenEducationIsEnded__createdNewStudent() {
        planeModelService.addOrganization(Organization_Theory8_practice2_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(Organization_Theory8_practice2_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(7));
        planeModelService.createStudent(testStudent_rate05_selfExp1);
        planeModelService.addOrganization(Organization_Theory8_practice2_discussion1);
        planeModelService.addOrganization(SelfEducation_Theory2_practice1_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(Organization_Theory8_practice2_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(SelfEducation_Theory2_practice1_discussion1);
        Student hStudent = planeModelService.educationEnd();
        assertThat(hStudent.getTotalExperience(), is(13));
    }

    @Test
    void educationEnd__withOneOrganizationForTwoDay() {
        planeModelService.addOrganization(SelfEducation_Theory2_practice1_discussion1);
        planeModelService.addStudentInToOrganizationRecruitedList(SelfEducation_Theory2_practice1_discussion1);
        Student student = planeModelService.educationEnd();
        assertThat(student.getTotalExperience(), is(6));
    }

    @Test
    void getDay__forUniversityOrganization_Expect5() {
        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(7));
        organizationType = new University();
        assertThat(organizationType.getDays(educationPeriod), is(5));
    }

    @Test
    void getDay__forMeeting__ExpectAlways1() {
        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(1000));
        organizationType = new Meeting();
        assertThat(organizationType.getDays(educationPeriod), is(1));
    }

    @Test
    void getDay__forMeetUp__ExpectAlways1() {
        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(50));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        assertThat(organizationType.getDays(educationPeriod), is(2));
    }

    @Test
    void getTotalExperience__inMeetUpWithoutNotebook__PracticeExperienceIs0() {
        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(50));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        Organization organization = new Organization(organizationType, educationPeriod,
                4, 1,1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);
        Student student = planeModelService.educationEnd();
        student.setStudentStuff(new Stuff(false, true, true));
        assertThat(student.getTotalExperience(), is(6));
    }

    @Test
    void createPlan__forOneWeek() {
        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(7));
        organizationType = new University();
        Organization organization = new Organization(organizationType, educationPeriod,
                4, 1, 1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(50));
        organizationType = new MeetUp(DayOfWeek.MONDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                4, 1,1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        educationPeriod = new EducationPeriod(LocalDate.now(), LocalDate.now().plusDays(7));
        organizationType = new SelfEducation();
        organization = new Organization(organizationType, educationPeriod,
                4, 1, 1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        educationPeriod = new EducationPeriod(LocalDate.now().plusDays(4));
        organizationType = new Meeting();
        organization = new Organization(organizationType, educationPeriod,
                4, 1,1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        planeModelService.createPlan(7);
        Student student = planeModelService.educationEnd();
        assertThat(planeModelService.getPlane(), is(1));
    }
}
