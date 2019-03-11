import planeModel.EducationPeriod;
import planeModel.InternShip;
import planeModel.MeetUp;
import planeModel.Meeting;
import planeModel.Organization;
import planeModel.OrganizationType;
import planeModel.PlaneModelService;
import planeModel.SelfEducation;
import planeModel.Student;
import planeModel.Stuff;
import planeModel.University;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
       // createPacifist();
        //createSelfExplorer();
       // createTheoretic();
        //createTheLivingWeapon();

    }

    private static void createTheLivingWeapon() {
        Stuff stuff = new Stuff(true, true, true);
        PlaneModelService planeModelService  = new PlaneModelService();
        Student initialStudent = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(initialStudent);

        LocalDate date = LocalDate.of(2016, 9, 1);
        EducationPeriod educationPeriod = new EducationPeriod(date, date.plusYears(5));
        OrganizationType organizationType = new University();
        Organization organization = new Organization(organizationType, educationPeriod,
                5, 1, 2);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2016, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusYears(3));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                3, 6, 3);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2017, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(3));
        organizationType = new MeetUp(DayOfWeek.MONDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                4, 3, 4);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2019, 3, 4);
        educationPeriod = new EducationPeriod(date, date.plusMonths(3));
        organizationType = new InternShip();
        organization = new Organization(organizationType, educationPeriod,
                4, 10, 3);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2015, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(5));
        organizationType = new SelfEducation();
        organization = new Organization(organizationType, educationPeriod,
                2, 2, 0);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2019, 3, 10);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        organization = new Organization(organizationType, educationPeriod,
                4, 8, 4);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2019, 3, 15);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        organization = new Organization(organizationType, educationPeriod,
                6, 4, 2);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2019, 1, 11);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        organization = new Organization(organizationType, educationPeriod,
                1, 10, 1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        planeModelService.createPlan(7);
        System.out.println(planeModelService.getPlane());
        initialStudent = planeModelService.educationEnd();
        System.out.println(initialStudent.getTotalExperience());
    }

    private static void createTheoretic() {
        Stuff stuff = new Stuff(false, true, true);
        PlaneModelService planeModelService  = new PlaneModelService();
        Student initialStudent = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(initialStudent);

        LocalDate date = LocalDate.of(2018, 9, 1);
        EducationPeriod educationPeriod = new EducationPeriod(date, date.plusYears(5));
        OrganizationType organizationType = new University();
        Organization organization = new Organization(organizationType, educationPeriod,
                3, 2, 2);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2018, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                5, 6, 6);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2019, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.MONDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                3, 10, 2);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        planeModelService.createPlan(7);
        System.out.println(planeModelService.getPlane());
        initialStudent = planeModelService.educationEnd();
        System.out.println(initialStudent.getTotalExperience());
    }

    private static void createSelfExplorer() {
        Stuff stuff = new Stuff(true, true, true);
        PlaneModelService planeModelService  = new PlaneModelService();
        Student initialStudent = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(initialStudent);

        LocalDate date = LocalDate.of(2019, 3, 4);
        EducationPeriod educationPeriod = new EducationPeriod(date, date.plusMonths(3));
        OrganizationType organizationType = new InternShip();
        Organization organization = new Organization(organizationType, educationPeriod,
                6, 10, 4);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2018, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        organization = new Organization(organizationType, educationPeriod,
                5, 6, 6);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        date = LocalDate.of(2018, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(2));
        organizationType = new SelfEducation();
        organization = new Organization(organizationType, educationPeriod,
                3, 2, 0);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        planeModelService.createPlan(7);
        System.out.println(planeModelService.getPlane());
        initialStudent = planeModelService.educationEnd();
        System.out.println(initialStudent.getTotalExperience());
    }

    private static void createPacifist() {
        Stuff stuff = new Stuff(false, false, false);
        PlaneModelService planeModelService  = new PlaneModelService();
        Student initialStudent = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(initialStudent);

        LocalDate date = LocalDate.of(2018, 9, 1);
        EducationPeriod educationPeriod = new EducationPeriod(date, date.plusYears(6));
        OrganizationType organizationType = new University();
        Organization organization = new Organization(organizationType, educationPeriod,
                4, 1, 1);
        planeModelService.addOrganization(organization);
        planeModelService.addStudentInToOrganizationRecruitedList(organization);

        planeModelService.createPlan(7);
        System.out.println(planeModelService.getPlane());
        initialStudent = planeModelService.educationEnd();
        System.out.println(initialStudent.getTotalExperience());
    }
}
