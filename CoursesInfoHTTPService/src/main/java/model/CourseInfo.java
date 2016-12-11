package model;

/**
 * Created by hamzaghani on 17/10/2016.
 */
public class CourseInfo {

    private String courseID, courseName, courseTutor;
    private int  courseCredits, courseDuration;

    public CourseInfo() {
        super();

    }

    public CourseInfo(String courseID, String courseName, String courseTutor, int courseCredits, int courseDuration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseTutor = courseTutor;
        this.courseCredits = courseCredits;
        this.courseDuration = courseDuration;
    }

    public String getCourseID() {
        return courseID;
    }

    public CourseInfo setCourseID(String courseID) {
        this.courseID = courseID;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseInfo setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getCourseTutor() {
        return courseTutor;
    }

    public CourseInfo setCourseTutor(String courseTutor) {
        this.courseTutor = courseTutor;
        return this;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public CourseInfo setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
        return this;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public CourseInfo setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
        return this;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTutor='" + courseTutor + '\'' +
                ", courseCredits=" + courseCredits +
                ", courseDuration=" + courseDuration +
                '}';
    }
}
