package dao;

import model.CourseInfo;

import java.util.HashMap;

/**
 * ENTERPRISE PROGRAMMING
 *
 * 17/10/2016
 *
 * @author hamzaghani
 * Interface providing methods for the CourseInfo Class
 *
 *
 */
public interface CourseInfoInterface {
    public void addCourse (CourseInfo cinfo);
    public HashMap<String,CourseInfo> listCourse ();
    public HashMap<String,CourseInfo> searchCourse(String searchStr);
}
