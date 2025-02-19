import java.io.*;
import java.util.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

class Admin {
    static List<Student> masterRegistry = new ArrayList<>();

    static void loadStudentsFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 2) {
                    masterRegistry.add(new Student(data[0], Integer.parseInt(data[1])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    static void saveStudentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Student student : masterRegistry) {
                writer.println(student.name + "," + student.id);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class CourseManagement {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Admin.loadStudentsFromFile("students.csv");
        
        while (true) {
            System.out.println("1. Admin Login\n2. Student Login\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    Admin.saveStudentsToFile("students.csv");
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void adminLogin() {
        System.out.println("Enter admin password:");
        String password = scanner.nextLine();
        if (!password.equals("admin123")) {
            System.out.println("Incorrect password.");
            return;
        }
        
        while (true) {
            System.out.println("1. Add Student\n2. View Students\n3. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter student ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student newStudent = new Student(name, id);
        if (!Admin.masterRegistry.contains(newStudent)) {
            Admin.masterRegistry.add(newStudent);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student already exists.");
        }
    }

    private static void viewStudents() {
        if (Admin.masterRegistry.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("Registered Students:");
            for (Student student : Admin.masterRegistry) {
                System.out.println(student.name + " (ID: " + student.id + ")");
            }
        }
    }

    private static void studentLogin() {
        System.out.println("Enter student ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (Student student : Admin.masterRegistry) {
            if (student.id == id) {
                System.out.println("Welcome, " + student.name + "!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
