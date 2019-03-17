import planeModel.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static PlaneModelService planeModelService  = new PlaneModelService();
    static Stuff stuff = new Stuff(true, true, true);
    static List<Student> students = new ArrayList<>();
    static LocalDate date2019_3_10 = LocalDate.of(2019, 3, 10);
    static LocalDate date2016_3_1 = LocalDate.of(2016, 3, 1);

    public static void main(String[] args) {
        createPacifist();
        createSelfExplorer();
        createTheoretic();
        createTheLivingWeapon();
    }

        private static void createTheLivingWeapon() {
            Plan livingWeaponPlan = new Plan("livingWeaponPLan");
            EducationPeriod educationPeriodForPlan = new EducationPeriod(date2019_3_10, date2019_3_10.plusDays(4));
            EducationPeriod educationPeriodForActivity = new EducationPeriod(date2019_3_10.minusDays(9),
                    date2019_3_10.minusDays(10).plusMonths(3));
            Student student = new Student("Andrii", 0.5, stuff);
            students.add(student);

            livingWeaponPlan.addActivity(new MeetUp("Oop", 4, 6,
                    DayOfWeek.THURSDAY, 1));
            livingWeaponPlan.addActivity(new SelfEducation("coursesFromMyHart", 4, 4));
            livingWeaponPlan.addActivity(new InternShip("InCamp", 10, 6,
                    educationPeriodForActivity));
            educationPeriodForActivity = new EducationPeriod(date2016_3_1, date2016_3_1.plusYears(5));
            livingWeaponPlan.addActivity(new Meeting("Valentin", 2, 4, date2019_3_10.plusDays(3)));
            livingWeaponPlan.addActivity(new University("chdtu", 2, 10,
                    educationPeriodForActivity));

            planeModelService.recruited(student, livingWeaponPlan, "chdtu");
            planeModelService.recruited(student, livingWeaponPlan, "InCamp");
            planeModelService.workWithPlan(students, livingWeaponPlan, educationPeriodForPlan);
            System.out.printf("%s Practice:%d Knowledge:%d\n", livingWeaponPlan.getName(),
                    student.getPracticeExperience(), student.getKnowledge());
            students = new ArrayList<>();
        }

        private static void createTheoretic() {
            Plan theoreticPlan = new Plan("theoreticPlan");
            EducationPeriod educationPeriodForPlan = new EducationPeriod(date2019_3_10, date2019_3_10.plusDays(4));
            EducationPeriod educationPeriodForActivity = new EducationPeriod(date2016_3_1, date2016_3_1.plusYears(5));
            Student student = new Student("Andrii", 0.5, stuff);
            students.add(student);

            theoreticPlan.addActivity(new University("chdtu", 2, 10,
                    educationPeriodForActivity));
            theoreticPlan.addActivity(new MeetUp("Oop", 4, 6,
                    DayOfWeek.THURSDAY, 1));
            theoreticPlan.addActivity(new MeetUp("Git", 2, 6,
                    DayOfWeek.MONDAY, 1));

            planeModelService.recruited(student, theoreticPlan, "chdtu");
            planeModelService.workWithPlan(students, theoreticPlan, educationPeriodForPlan);
            System.out.printf("%s Practice:%d Knowledge:%d\n", theoreticPlan.getName(),
                    student.getPracticeExperience(), student.getKnowledge());
            students = new ArrayList<>();
        }


        private static void createSelfExplorer() {
            Plan explorerPlan = new Plan("explorer");
            EducationPeriod educationPeriodForPlan = new EducationPeriod(date2019_3_10, date2019_3_10.plusDays(4));
            EducationPeriod educationPeriodForActivity = new EducationPeriod(date2019_3_10.minusDays(9),
                    date2019_3_10.minusDays(10).plusMonths(3));
            Student student = new Student("Andrii", 0.5, stuff);
            students.add(student);

            explorerPlan.addActivity(new MeetUp("Oop", 4, 6,
                    DayOfWeek.THURSDAY, 1));
            explorerPlan.addActivity(new SelfEducation("coursesFromMyHart", 4, 4));
            explorerPlan.addActivity(new InternShip("InCamp", 10, 6,
                    educationPeriodForActivity));

            planeModelService.recruited(student, explorerPlan, "InCamp");
            planeModelService.workWithPlan(students, explorerPlan, educationPeriodForPlan);
            System.out.printf("%s Practice:%d Knowledge:%d\n", explorerPlan.getName(),
                    student.getPracticeExperience(), student.getKnowledge());
            students = new ArrayList<>();
        }

    private static void createPacifist() {
        Plan pacifistPlan = new Plan("pacifist");
        EducationPeriod educationPeriodForPlan = new EducationPeriod(date2019_3_10, date2019_3_10.plusDays(4));
        EducationPeriod educationPeriodForActivity = new EducationPeriod(date2016_3_1, date2016_3_1.plusYears(5));
        Student student = new Student("Andrii", 0.5, stuff);
        students.add(student);

        pacifistPlan.addActivity(new University("chdtu", 2, 10,
                educationPeriodForActivity));

        planeModelService.recruited(student, pacifistPlan, "chdtu");
        planeModelService.workWithPlan(students, pacifistPlan, educationPeriodForPlan);
        System.out.printf("%s Practice:%d Knowledge:%d\n", pacifistPlan.getName(),
                student.getPracticeExperience(), student.getKnowledge());
        students = new ArrayList<>();
    }
}
