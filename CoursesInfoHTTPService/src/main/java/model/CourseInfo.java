package model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.awt.print.Book;

/**
 * Created by hamzaghani on 17/10/2016.
 */

@XmlRootElement
@XmlType(propOrder = { "courseID", "courseName", "courseTutor", "courseCredits", "courseDuration"})
public class CourseInfo {


     String courseID, courseName, courseTutor,courseCredits, courseDuration;;


    public CourseInfo() {
        super();

    }


    public CourseInfo(String courseID, String courseName, String courseTutor, String courseCredits, String courseDuration) {
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
