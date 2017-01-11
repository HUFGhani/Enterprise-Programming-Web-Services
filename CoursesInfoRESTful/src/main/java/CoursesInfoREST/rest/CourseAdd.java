package CoursesInfoREST.rest;

/**
 * Created by hamzaghani on 11/01/2017.
 */

import CoursesInfoREST.dao.CourseInfoDAO;
import CoursesInfoREST.model.CourseInfo;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;



@Path("add/course")
public class CourseAdd {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @POST
    public String AddCourse(@FormParam("courseName") String courseName,
                            @FormParam("courseTutor") String courseTutor,
                            @FormParam("courseCredits") String courseCredits,
                            @FormParam("courseDuration") String courseDuration){
        String message;
        if(courseName.equals(null) || courseName.isEmpty() ||
                courseTutor.equals(null) || courseTutor.isEmpty() ||
                courseCredits.equals(null) || courseCredits.isEmpty() ||
                courseDuration.equals(null) || courseDuration.isEmpty()) {
           message = "sorry can't accepted blank spaces";
        }else{
            CourseInfo courseInfo = new CourseInfo();
            courseInfo.setCourseName(courseName);
            courseInfo.setCourseTutor(courseTutor);
            courseInfo.setCourseCredits(courseCredits);
            courseInfo.setCourseDuration(courseDuration);
            CourseInfoDAO.instance.addCourse(courseInfo);
            message= "data has been add now";
        }
 return  message;
    }
}