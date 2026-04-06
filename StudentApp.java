import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int age, String course) {
        students.add(new Student(name, age, course));
        System.out.println("Student added!\n");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
            return;
        }

        for (Student s : students) {
            s.display();
        }
        System.out.println();
    }

    public void searchStudent(String name) {
        boolean found = false;

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.\n");
        }
    }

    public void deleteStudent(String name) {
        students.removeIf(s -> s.getName().equalsIgnoreCase(name));
        System.out.println("If student existed, it has been removed.\n");
    }
}

// Main class
public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    manager.addStudent(name, age, course);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    manager.searchStudent(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    manager.deleteStudent(sc.nextLine());
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
}