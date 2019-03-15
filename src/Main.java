public class Main {

    public static void main(String[] args) {
        // createPacifist();
        // createSelfExplorer();
        // createTheoretic();
        //  createTheLivingWeapon();
    }
/*

    private static void createTheLivingWeapon() {
        Stuff stuff = new Stuff(true, true, true);
        PlaneModelService planeModelService  = new PlaneModelService();
        Student initialStudent = new Student("Andrii", 0.5, stuff);
        planeModelService.createStudent(initialStudent);

        LocalDate date = LocalDate.of(2016, 9, 1);
        EducationPeriod educationPeriod = new EducationPeriod(date, date.plusYears(5));
        Condition organizationType = new University();
        Activity activity = new Activity(organizationType, educationPeriod,
                5, 1, 2);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2016, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusYears(3));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        activity = new Activity(organizationType, educationPeriod,
                3, 6, 3);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2017, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(3));
        organizationType = new MeetUp(DayOfWeek.MONDAY, 1);
        activity = new Activity(organizationType, educationPeriod,
                4, 3, 4);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2019, 3, 4);
        educationPeriod = new EducationPeriod(date, date.plusMonths(3));
        organizationType = new InternShip();
        activity = new Activity(organizationType, educationPeriod,
                4, 10, 3);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2015, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(5));
        organizationType = new SelfEducation();
        activity = new Activity(organizationType, educationPeriod,
                2, 2, 0);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2019, 3, 10);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        activity = new Activity(organizationType, educationPeriod,
                4, 8, 4);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2019, 3, 15);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        activity = new Activity(organizationType, educationPeriod,
                6, 4, 2);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2019, 1, 11);
        educationPeriod = new EducationPeriod(date);
        organizationType = new Meeting();
        activity = new Activity(organizationType, educationPeriod,
                1, 10, 1);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

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
        Condition organizationType = new University();
        Activity activity = new Activity(organizationType, educationPeriod,
                3, 2, 2);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2018, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        activity = new Activity(organizationType, educationPeriod,
                5, 6, 6);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2019, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.MONDAY, 1);
        activity = new Activity(organizationType, educationPeriod,
                3, 10, 2);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

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
        Condition organizationType = new InternShip();
        Activity activity = new Activity(organizationType, educationPeriod,
                6, 10, 4);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2018, 10, 15);
        educationPeriod = new EducationPeriod(date, date.plusMonths(6));
        organizationType = new MeetUp(DayOfWeek.THURSDAY, 1);
        activity = new Activity(organizationType, educationPeriod,
                5, 6, 6);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        date = LocalDate.of(2018, 1, 1);
        educationPeriod = new EducationPeriod(date, date.plusYears(2));
        organizationType = new SelfEducation();
        activity = new Activity(organizationType, educationPeriod,
                3, 2, 0);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

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
        Condition organizationType = new University();
        Activity activity = new Activity(organizationType, educationPeriod,
                4, 1, 1);
        planeModelService.addOrganization(activity);
        planeModelService.addStudentInToOrganizationRecruitedList(activity);

        planeModelService.createPlan(7);
        System.out.println(planeModelService.getPlane());
        initialStudent = planeModelService.educationEnd();
        System.out.println(initialStudent.getTotalExperience());
    }
*/
}
