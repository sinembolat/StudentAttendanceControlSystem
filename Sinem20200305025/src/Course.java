import java.util.ArrayList;
import java.util.List;

public class Course implements AttendanceStatistics {
    private String courseName;
    private List<Student> students;
    private List<List<Boolean>> weeklyAttendance;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.weeklyAttendance = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        weeklyAttendance.add(new ArrayList<>());
    }

    @Override
    public int getAttendanceCountForWeek(int week) {
        int count = 0;
        for (Student student : students) {
            List<List<Boolean>> studentWeeklyAttendance = student.getWeeklyAttendance();
            if (week < studentWeeklyAttendance.size()) {
                if (studentWeeklyAttendance.get(week).size() > 0 && studentWeeklyAttendance.get(week).get(0)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<Integer> getWeeklyAttendanceStatistics() {
        List<Integer> statistics = new ArrayList<>();
        for (int week = 0; week < weeklyAttendance.size(); week++) {
            statistics.add(getAttendanceCountForWeek(week));
        }
        return statistics;
    }
}


