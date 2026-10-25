package DSA.EasyDSA.Student;

public class Student {

    private String name;
    private int roll;
    private double marks;

    public Student(String name, int roll, double marks) {
        // TODO: write logic
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    void display() {
        // TODO: write logic
        System.out.println("name " + this.name);
        System.out.println("roll " + this.roll);
        System.out.println("marks " + this.marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Aarav", 1, 88.5);
        Student s2 = new Student("Diya", 2, 92.0);
        s1.display();
        s2.display();
    }
}
