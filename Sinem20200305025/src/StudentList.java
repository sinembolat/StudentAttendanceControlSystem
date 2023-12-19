import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> filterStudents(Predicate<Student> filterCondition) {
        return students.stream()
                .filter(filterCondition)
                .collect(Collectors.toList());
    }

    public void displayStudentsByDepartment(String department) {
        Predicate<Student> byDepartment = student -> student.getCourses().stream()
                .anyMatch(course -> course.getCourseName().equalsIgnoreCase(department));

        List<Student> filteredStudents = filterStudents(byDepartment);

        System.out.println("\nStudents in " + department + " Department:");
        for (Student student : filteredStudents) {
            System.out.println("Name: " + student.getName() + ", Department: " + department);
        }
    }

    public void displayAllStudents() {
        System.out.println("\nAll Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Departments: " + student.getCourses());
        }
    }

    public static void main(String[] args) {
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

        studentList.displayStudentsByDepartment("Economy");
        studentList.displayStudentsByDepartment("Business");

        studentList.displayAllStudents();
    }
}


