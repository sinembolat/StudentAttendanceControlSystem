import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (LoginScreen.authenticate()) {
            Course economyCourse = new Course("Economy");
            Course businessCourse = new Course("Business");

            Student student1 = new Student("Cem Sarıçam");
            Student student2 = new Student("Aysu Akgül");
            Student student3 = new Student("Helin Akbaba");
            Student student4 = new Student("Dilara Erdem");
            Student student5 = new Student("Asya Rıfatoğlu");
            Student student6 = new Student("Ahsen Kavi");
            Student student7 = new Student("Mehmet Bingül");
            Student student8 = new Student("Zehra Arlı");
            Student student9 = new Student("Göksenin Yücelen");
            Student student10 = new Student("Sude Yürek");

            student1.addCourse(economyCourse);
            student2.addCourse(businessCourse);
            student3.addCourse(economyCourse);
            student4.addCourse(businessCourse);
            student5.addCourse(economyCourse);
            student6.addCourse(economyCourse);
            student7.addCourse(businessCourse);
            student8.addCourse(businessCourse);
            student9.addCourse(economyCourse);
            student10.addCourse(economyCourse);

            economyCourse.addStudent(student1);
            businessCourse.addStudent(student2);
            economyCourse.addStudent(student3);
            businessCourse.addStudent(student4);
            economyCourse.addStudent(student5);
            economyCourse.addStudent(student6);
            businessCourse.addStudent(student7);
            businessCourse.addStudent(student8);
            economyCourse.addStudent(student9);
            economyCourse.addStudent(student10);

            List<Course> courses = new ArrayList<>();
            courses.add(economyCourse);
            courses.add(businessCourse);

            SystemStatistics systemStatistics = new SystemStatistics(courses.size());
            AttendanceControlSystem attendanceSystem = new AttendanceControlSystem(courses, systemStatistics);
            StudentList studentList = initializeStudentList();

            showAdminOptions(attendanceSystem, systemStatistics, studentList);
        } else {
            System.out.println("Exiting the program. Goodbye!");
        }
    }
    
    private static void showAdminOptions(AttendanceControlSystem attendanceSystem, SystemStatistics systemStatistics, StudentList studentList) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdmin Options:");
            System.out.println("1. Mark attendance for Economy");
            System.out.println("2. Mark attendance for Business");
            System.out.println("3. Display Attendance Report");
            System.out.println("4. Display Attendance Statistics");
            System.out.println("5. Display Generic Data");
            System.out.println("6. Display Student List");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            String choiceString = scanner.next();

            if (choiceString.matches("\\d+")) {
                int choice = Integer.parseInt(choiceString);

                switch (choice) {
                    case 1 -> markAttendance("Economy", attendanceSystem);
                    case 2 -> markAttendance("Business", attendanceSystem);
                    case 3 -> attendanceSystem.displayAttendanceReport();
                    case 4 -> {
                        System.out.print("Enter course name to display attendance statistics: ");
                        String courseName = scanner.next();
                        attendanceSystem.displayAttendanceStatistics(courseName);
                    }
                    case 5 -> displayGenericData(new GenericPrinter<>(systemStatistics));
                    case 6 -> {
                        System.out.print("Enter department to display students: ");
                        String department = scanner.next();
                        studentList.displayStudentsByDepartment(department);
                    }
                    case 7 -> {
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void markAttendance(String courseName, AttendanceControlSystem attendanceSystem) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the week number: ");
        int week = scanner.nextInt();

        attendanceSystem.markAttendance(courseName, week);
    }

    private static void displayGenericData(GenericPrinter<SystemStatistics> printer) {
        printer.printData();
    }

    private static StudentList initializeStudentList() {
        StudentList studentList = new StudentList();

        Course economyCourse = new Course("Economy");
        Course businessCourse = new Course("Business");

        Student student1 = new Student("Cem Sarıçam");
        student1.addCourse(economyCourse);
        Student student2 = new Student("Aysu Akgül");
        student2.addCourse(businessCourse);
        Student student3 = new Student("Helin Akbaba");
        student3.addCourse(economyCourse);
        Student student4 = new Student("Dilara Erdem");
        student4.addCourse(businessCourse);
        Student student5 = new Student("Asya Rıfatoğlu");
        student5.addCourse(economyCourse);
        Student student6 = new Student("Ahsen Kavi");
        student6.addCourse(economyCourse);
        Student student7 = new Student("Mehmet Bingül");
        student7.addCourse(businessCourse);
        Student student8 = new Student("Zehra Arlı");
        student8.addCourse(businessCourse);
        Student student9 = new Student("Göksenin Yücelen");
        student9.addCourse(economyCourse);
        Student student10 = new Student("Sude Yürek");
        student10.addCourse(economyCourse);

        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);
        studentList.addStudent(student4);
        studentList.addStudent(student5);
        studentList.addStudent(student6);
        studentList.addStudent(student7);
        studentList.addStudent(student8);
        studentList.addStudent(student9);
        studentList.addStudent(student10);

        return studentList;
    }
}
