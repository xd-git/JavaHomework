import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Couse couse = new Couse("Java");

        couse.addStudent(new Student("Jack", new Address("XiAn", "XingLong Street, 266", 710126), 80));
        couse.addStudent(new Student("Black", new Address("XiAn", "XingLong Street, 266", 710126), 90));
        couse.addStudent(new Student("Chris", new Address("XiAn", "XingLong Street, 266", 710126), 88));
        couse.addStudent(new Student("Dynis", new Address("XiAn", "XingLong Street, 266", 710126), 68));

        couse.roll();
        System.out.println();
        System.out.println("Ths Class average source is " + couse.average());
        
    }
}