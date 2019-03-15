import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planeModel.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlaneModelServiceTest {
    private PlaneModelService planeModelService;
    Student testStudent_rate05_selfExp1;
    EducationPeriod educationPeriodForPlan;
    EducationPeriod educationPeriodForOrganization;
    LocalDate date;
    LocalDate date2;
    Student students;
    Plan pacifistPlan;

    @BeforeEach
    void setUp() {
        Stuff stuff = new Stuff(true, true, true);
        planeModelService  = new PlaneModelService();
        testStudent_rate05_selfExp1 = new Student("Andrii", 0.5, stuff);
        //-----------------------------------------------------------------------------------------------
        pacifistPlan = new Plan("pacifist");
        students = new Student(testStudent_rate05_selfExp1.getName(),
                testStudent_rate05_selfExp1.getLearningRate(), testStudent_rate05_selfExp1.getStudentsStuff());
        date = LocalDate.of(2019, 3, 10);
        educationPeriodForPlan = new EducationPeriod(date, date.plusDays(4));
        date2 = LocalDate.of(2016, 3, 1);
        educationPeriodForOrganization = new EducationPeriod(date2, date.plusMonths(3));
    }

    @Test
    void workWithPlan__forUniversityOnly() {
        pacifistPlan.addOrganization(new University("chdtu", 2, 2,
                educationPeriodForOrganization));
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(students.getPracticeExperience(), is(10));
        assertThat(students.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forInternShipOnly() {
        pacifistPlan.addOrganization(new InternShip("InCamp", 2, 2,
                educationPeriodForOrganization));
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(students.getPracticeExperience(), is(10));
        assertThat(students.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forMeetUpOnly() {
        pacifistPlan.addOrganization(new MeetUp("Oop", 2, 2,
                DayOfWeek.THURSDAY, 1));
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(students.getPracticeExperience(), is(10));
        assertThat(students.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forMeetingOnly() {
        pacifistPlan.addOrganization(new Meeting("InCamp", 2, 2,
                educationPeriodForOrganization));
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(students.getPracticeExperience(), is(10));
        assertThat(students.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forSelfEducationOnly() {
        pacifistPlan.addOrganization(new SelfEducation("InCamp", 2, 2,
                educationPeriodForOrganization));
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(students.getPracticeExperience(), is(10));
        assertThat(students.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }
}
