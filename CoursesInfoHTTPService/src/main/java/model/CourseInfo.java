package model;

/**
 * Created by hamzaghani on 17/10/2016.
 */
public class CourseInfo {

    String courseID, courseName, courseCredits, courseDuration,courseTutor;

    public CourseInfo(){
        super();

    }

    public CourseInfo(String courseID, String courseName, String courseCredits, String courseDuration, String courseTutor) {
        super();
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.courseDuration = courseDuration;
        this.courseTutor = courseTutor;
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

    public String getCourseCredits() {
        return courseCredits;
    }

    public CourseInfo setCourseCredits(String courseCredits) {
        this.courseCredits = courseCredits;
        return this;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public CourseInfo setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
        return this;
    }

    public String getCourseTutor() {
        return courseTutor;
    }

    public CourseInfo setCourseTutor(String courseTutor) {
        this.courseTutor = courseTutor;
        return this;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCredits='" + courseCredits + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", courseTutor='" + courseTutor + '\'' +
                '}';
    }
}
