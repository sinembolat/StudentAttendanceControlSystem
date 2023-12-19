import java.util.List;
import java.util.Scanner;

public class AttendanceControlSystem {
    private List<Course> courses;
    private SystemStatistics systemStatistics;

    public AttendanceControlSystem(List<Course> courses, SystemStatistics systemStatistics) {
        this.courses = courses;
        this.systemStatistics = systemStatistics;
    }

    public void markAttendance(String courseName, int week) {
        Scanner scanner = new Scanner(System.in);

        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                List<Student> students = course.getStudents();
                for (Student student : students) {
                    System.out.print("Enter attendance for " + student.getName() + " in " + courseName + " for week " + week + ": ");
                    boolean isPresent = scanner.nextBoolean();

                    int courseIndex = courses.indexOf(course);
                    if (courseIndex != -1) {
                        student.markAttendance(week - 1, isPresent);
                        systemStatistics.incrementTotalStudents();
                        systemStatistics.incrementStudentsPerCourse(courseIndex);
                    } else {
                        System.out.println("Error: Course not found.");
                    }
                }
                break;
            }
        }
    }

    public void displayAttendanceStatistics(String courseName) {
        boolean courseFound = false;

        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                courseFound = true;
                System.out.println("\nAttendance Statistics for Course: " + courseName);

                List<Integer> weeklyStatistics = course.getWeeklyAttendanceStatistics();
                for (int week = 0; week < weeklyStatistics.size(); week++) {
                    System.out.println("Week " + (week + 1) + ": " + weeklyStatistics.get(week) + " students present");
                }

                break;
            }
        }
        if (!courseFound) {
            System.out.println("Course not found: " + courseName + ". Available courses are: " + getCoursesList());

        }
    }

    private String getCoursesList() {
        StringBuilder coursesList = new StringBuilder();
        for (Course course : courses) {
            coursesList.append(course.getCourseName()).append(", ");
        }

        if (coursesList.length() > 2) {
            coursesList.setLength(coursesList.length() - 2);
        }
        return coursesList.toString();
    }

    public void displayAttendanceReport() {
        System.out.println("\nAttendance Report:");

        for (Course course : courses) {
            System.out.println("\nCourse: " + course.getCourseName());

            List<Student> students = course.getStudents();
            for (Student student : students) {
                System.out.println("\nStudent: " + student.getName());

                List<List<Boolean>> weeklyAttendance = student.getWeeklyAttendance();
                for (int week = 0; week < weeklyAttendance.size(); week++) {
                    System.out.print("Week " + (week + 1) + ": ");

                    List<Boolean> attendanceList = weeklyAttendance.get(week);
                    if (attendanceList.isEmpty()) {
                        System.out.print("Not marked");
                    } else {
                        for (boolean isPresent : attendanceList) {
                            System.out.print(isPresent + " ");
                        }
                    }

                    System.out.println();
                }
            }
        }
    }
}


