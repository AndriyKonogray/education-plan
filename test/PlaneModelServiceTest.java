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
    Student testStudent_rate05_selfExp1;
    EducationPeriod educationPeriodForPlan;
    EducationPeriod educationPeriodForActivity;
    LocalDate date;
    LocalDate date2;
    Plan pacifistPlan;
    List<Student> students;

    @BeforeEach
    void setUp() {
        Stuff stuff = new Stuff(false, true, true);
        planeModelService  = new PlaneModelService();
        testStudent_rate05_selfExp1 = new Student("Andrii", 0.5, stuff);
        students = new ArrayList<>();
        pacifistPlan = new Plan("pacifist");
        students.add(new Student(testStudent_rate05_selfExp1.getName(),
                testStudent_rate05_selfExp1.getLearningRate(), testStudent_rate05_selfExp1.getStudentsStuff()));
        date = LocalDate.of(2019, 3, 10);
        educationPeriodForPlan = new EducationPeriod(date, date.plusDays(4));
        date2 = LocalDate.of(2016, 3, 1);
        educationPeriodForActivity = new EducationPeriod(date2, date2.plusYears(5));
    }

    @Test
    void workWithPlan__forUniversityOnly__WhenEducationPeriodIsOver__Expect0() {
        educationPeriodForActivity = new EducationPeriod(date2.minusYears(10), date2.minusYears(5));
        pacifistPlan.addActivity(new University("chdtu", 2, 2,
                educationPeriodForActivity));
        Student student = students.get(0);
        planeModelService.recruited(student, pacifistPlan, "chdtu");
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(student.getPracticeExperience(), is(0));
        assertThat(student.getKnowledge(), is(0));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forInternShipOnly__WhenStartDoItBeforeInternShipStart__expectIgnoreThatDay() {
        educationPeriodForActivity = new EducationPeriod(date, date.plusDays(4));
        educationPeriodForPlan = new EducationPeriod(date.minusDays(5), date.plusDays(4));
        pacifistPlan.addActivity(new InternShip("InCamp", 2, 2,
                educationPeriodForActivity));
        Student student = students.get(0);
        planeModelService.recruited(student, pacifistPlan, "InCamp");
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(student.getPracticeExperience(), is(8));
        assertThat(student.getKnowledge(), is(4));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forMeetUpOnly__EveryThursdayOneTimePerMonth__WithoutNotebook__expectZeroPractice() {
        pacifistPlan.addActivity(new MeetUp("Oop", 2, 2,
                DayOfWeek.THURSDAY, 1));
        Student student = students.get(0);
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(student.getPracticeExperience(), is(0));
        assertThat(student.getKnowledge(), is(1));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forMeetingOnly__inCurrentDate() {
        pacifistPlan.addActivity(new Meeting("Valentin", 2, 2,
                date.plusDays(2)));
        Student student = students.get(0);
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(student.getPracticeExperience(), is(2));
        assertThat(student.getKnowledge(), is(1));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }

    @Test
    void workWithPlan__forSelfEducationOnly__EveryDay() {
        pacifistPlan.addActivity(new SelfEducation("HomeWork", 2, 2));
        Student student = students.get(0);
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        assertThat(student.getPracticeExperience(), is(10));
        assertThat(student.getKnowledge(), is(5));
        assertThat(pacifistPlan.getName(), is("pacifist"));
    }
}
