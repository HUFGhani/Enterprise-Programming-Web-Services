package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by hamzaghani on 12/12/2016.
 * the model for which is use xml and json 
 */
@XmlRootElement(name = "CourseInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    @XmlElement(name = "course")
    @SerializedName("CourseInfo")
    private List<CourseInfo> courseInfo = null;

    public List<CourseInfo> getCourseInfo() {
        return courseInfo;
    }

    public Course setCourseInfo(List<CourseInfo> courseInfo) {
        this.courseInfo = courseInfo;
        return this;
    }
}
