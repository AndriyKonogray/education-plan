package planeModel;

public class Student {
    private String name;
    private double learningRate;
    private Stuff studentsStuff;
    private int practiceExperience;
    private int knowledge;

    public Student(String name, double learningRate, Stuff studentsStuff) {
        this.name = name;
        this.learningRate = learningRate;
        this.studentsStuff = studentsStuff;
    }

    public Student() {
    }


    public void takeKnowledge(Plan plan, EducationPeriod educationPeriod) {
       plan.goTakeKnowledge(educationPeriod, this);
    }

    public  int getKnowledge() {
        return knowledge;
    }

    public void practice(Plan plan, EducationPeriod educationPeriod) {
        plan.goPractice(educationPeriod, this);
    }

    public int getPracticeExperience() {
        return practiceExperience;
    }

    private void setPracticeExperience(int practiceExperience) {
        this.practiceExperience = practiceExperience;
    }

    private void setKnowledge(int knowledge) {
        this.knowledge += knowledge;
    }

    //------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public Stuff getStudentsStuff() {
        return studentsStuff;
    }

    public void setStudentStuff(Stuff stuff) {
        this.studentsStuff = new Stuff(stuff.notebook, stuff.notepad, stuff.pen);
    }
}
