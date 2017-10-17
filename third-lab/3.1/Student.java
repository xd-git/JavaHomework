public class Student {
    private String name;
    private Address homeAddress;
    private int score;

    public Student(String n, Address h, int s) {
        this.name = n;
        this.homeAddress = h;
        this.score = s;
    }

    public String getName() {
        return this.name;
    }

    public Address getHomeAddress() {
        return this.homeAddress;
    }

    public int getScore() {
        return this.score;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setHomeAddress(Address a) {
        this.homeAddress = a;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public String toString() {
        return "Student " + this.name + " is in " + this.homeAddress + ", his score is " + this.score + "\n";
    }
}