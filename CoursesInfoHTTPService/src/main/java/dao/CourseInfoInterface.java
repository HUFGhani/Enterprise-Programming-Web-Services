package dao;

import model.CourseInfo;

import java.util.HashMap;

/**
 * ENTERPRISE PROGRAMMING
 * <p>
 * 17/10/2016
 *
 * @author hamzaghani
 *         Interface providing methods for the CourseInfo Class
 */
public interface CourseInfoInterface {
    public void addCourse(CourseInfo cinfo);

    public abstract HashMap<String, CourseInfo> listCourse();

    public abstract HashMap<String, CourseInfo> searchCourse(String searchStr);


}
