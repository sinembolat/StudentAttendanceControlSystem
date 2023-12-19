public class SystemStatistics {
    private int totalStudents;
    private int totalCourses;
    private int[] studentsPerCourse;

    public SystemStatistics(int totalCourses) {
        this.totalStudents = 0;
        this.totalCourses = totalCourses;
        this.studentsPerCourse = new int[totalCourses];
    }

    @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Total Students: " + totalStudents +
                    ", Total Courses: " + totalCourses + ", Students Per Course: ");

            for (int i = 0; i < studentsPerCourse.length; i++) {
                result.append("Course ").append(i + 1).append(": ").append(studentsPerCourse[i]);
                if (i < studentsPerCourse.length - 1) {
                    result.append(", ");
                }
            }

            return result.toString();
        }

    public void incrementTotalStudents() {
        this.totalStudents++;
    }

    public void incrementStudentsPerCourse(int courseIndex) {
        if (courseIndex >= 0 && courseIndex < totalCourses) {
            studentsPerCourse[courseIndex]++;
        }

    }
}
