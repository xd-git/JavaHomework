import java.util.ArrayList;

public class Couse {
    private String subjectName;
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Couse(String subject) {
        this.subjectName = subject;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public double average() {
        double sum = 0;
        int count = 0;
        for (Student stu : studentList) {
            sum += stu.getScore();
            count ++;
        }
        return (sum / count);
    }

    public void roll() {
        System.out.println("The students in Class " + this.subjectName + " show as flow:");
        for (Student stu : studentList) {
            System.out.println(stu.getName());
        }
    }
}