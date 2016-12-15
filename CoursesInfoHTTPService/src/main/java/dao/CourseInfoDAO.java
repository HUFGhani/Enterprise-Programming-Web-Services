package dao;

import com.google.appengine.api.datastore.*;
import model.CourseInfo;

import java.util.HashMap;

/**
 * Created by hamzaghani on 18/10/2016.
 */
public class CourseInfoDAO implements CourseInfoInterface {

    static CourseInfoInterface courseInfoInterface = new CourseInfoDAO();
    DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
    private static HashMap<String, CourseInfo> courseInfoMapData;
    private static HashMap<String, CourseInfo> courseInfoMData = new HashMap<String, CourseInfo>();

    public static HashMap<String, CourseInfo> getDatastoreEntries() {
        courseInfoMData = courseInfoInterface.listCourse();
        return courseInfoMData;
    }

    @Override
    public HashMap<String, CourseInfo> listCourse() {
        DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
        courseInfoMapData = new HashMap<String, CourseInfo>();
        Query query = new Query("CourseDetails");
        PreparedQuery googleQuery = dataStore.prepare(query);

        if (googleQuery.countEntities(FetchOptions.Builder.withDefaults()) < 1) {
            addNewDatastoreEntries();
        }

        for (Entity datastoreEntity : googleQuery.asIterable()) {
            String idKey = datastoreEntity.getKey().toString();
            String id = idKey.substring(idKey.indexOf("(") + 1, idKey.indexOf(")"));
            String courseName = datastoreEntity.getProperty("CourseName").toString();
            String couresCredits = datastoreEntity.getProperty("CouresCredits").toString();
            String courseDuration = datastoreEntity.getProperty("CourseDuration").toString();
            String courseTutor = datastoreEntity.getProperty("CourseTutor").toString();

            courseInfoMapData.put(id, new CourseInfo(id, courseName, courseTutor, couresCredits, courseDuration));
        }


        return courseInfoMapData;
    }

    @Override
    public void addCourse(CourseInfo cinfo) {
        Entity course = new Entity("CourseDetails");
        course.setProperty("CourseName", cinfo.getCourseName());
        course.setProperty("CouresCredits", cinfo.getCourseCredits());
        course.setProperty("CourseDuration", cinfo.getCourseDuration());
        course.setProperty("CourseTutor", cinfo.getCourseTutor());

        dataStore.put(course);
    }

    @Override
    public HashMap<String, CourseInfo> searchCourse(String searchStr) {
        HashMap<String, CourseInfo> courseInfoMapData = getDatastoreEntries();
        HashMap<String, CourseInfo> courseList = new HashMap<String, CourseInfo>();
        for (CourseInfo info : courseInfoMapData.values()) {
            if (info.getCourseName().equalsIgnoreCase(searchStr)) {
                courseList.put(info.getCourseID(), new CourseInfo(info.getCourseID(), info.getCourseName(),
                        info.getCourseTutor(), info.getCourseCredits(), info.getCourseDuration()));
            }
        }

        return courseList;
    }

    private void addNewDatastoreEntries() {

        Entity course = new Entity("CourseDetails");
        course.setProperty("CourseName","BSc (Hons) Computer Science");
        course.setProperty("CouresCredits","300");
        course.setProperty("CourseDuration","3");
        course.setProperty("CourseTutor","Dr Johnathon Robson");

        dataStore.put(course);
    }

}
