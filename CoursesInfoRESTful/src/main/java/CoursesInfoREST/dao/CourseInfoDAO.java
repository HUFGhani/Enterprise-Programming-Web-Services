package CoursesInfoREST.dao;

import CoursesInfoREST.model.CourseInfo;
import com.google.appengine.api.datastore.*;

import java.util.HashMap;

/**
 * Created by hamzaghani on 15/12/2016.
 */
public enum CourseInfoDAO {
    instance;

    private static HashMap<String, CourseInfo> addCourseData;
    DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();



// to get all course for dataStore
    public HashMap<String, CourseInfo> listCourse() {

        addCourseData = new HashMap<String, CourseInfo>();
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

            addCourseData.put(id, new CourseInfo(id, courseName, courseTutor, couresCredits, courseDuration));
        }

        return addCourseData;
    }
//to add data users input in to dataStore
    public void addCourse(CourseInfo cinfo) {
        Entity course = new Entity("CourseDetails");
        course.setProperty("CourseName", cinfo.getCourseName());
        course.setProperty("CouresCredits", cinfo.getCourseCredits());
        course.setProperty("CourseDuration", cinfo.getCourseDuration());
        course.setProperty("CourseTutor", cinfo.getCourseTutor());

        dataStore.put(course);
    }
     //add data to dataStore
    private void addNewDatastoreEntries() {

        System.out.println("IN the datastoreEntry Method");
        Entity course = new Entity("CourseDetails");
        course.setProperty("CourseName","BSc (Hons) Computer Science");
        course.setProperty("CouresCredits","300");
        course.setProperty("CourseDuration","3");
        course.setProperty("CourseTutor","Dr Johnathon Robson");

        Entity course1 = new Entity("CourseDetails");
        course1.setProperty("CourseName","BSc (Hons) Software Engineering");
        course1.setProperty("CouresCredits","360");
        course1.setProperty("CourseDuration","3");
        course1.setProperty("CourseTutor","Dr James Bond");

        Entity course2 = new Entity("CourseDetails");
        course2.setProperty("CourseName","BSc (Hons) Computer and Network Technology");
        course2.setProperty("CouresCredits","300");
        course2.setProperty("CourseDuration","3");
        course2.setProperty("CourseTutor","Dr Bob Smith");

        dataStore.put(course);
        dataStore.put(course1);
        dataStore.put(course2);
    }


}
