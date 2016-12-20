package CoursesInfoREST.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by hamzaghani on 12/12/2016.
 */
@XmlRootElement(name = "CourseInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    @XmlElement(name = "course")
    private List<CourseInfo> courseInfos = null;

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public Course setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
        return this;
    }
}
