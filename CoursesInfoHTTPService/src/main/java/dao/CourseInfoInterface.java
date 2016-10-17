package dao;

import model.CourseInfo;

import java.util.Collection;

/**
 * ENTERPRISE PROGRAMMING
 *
 * @author hamzaghani
 * Interface providing methods for the CourseInfo Class
 *
 *
 */
public interface CourseInfoInterface {
    public void addCourse (CourseInfo cinfo);
    public Collection listCourse ();
    public Collection searchCourse(String searchStr);
}
