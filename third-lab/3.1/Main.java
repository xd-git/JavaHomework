import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Couse couse = new Couse("Java");
        couse.addStudent(new Student("Jack", new Address("XiAn", "JingLong 266", 710126)));
        couse.average();
    }
}