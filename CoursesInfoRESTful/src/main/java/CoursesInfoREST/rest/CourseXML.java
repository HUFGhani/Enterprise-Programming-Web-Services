package CoursesInfoREST.rest;

import CoursesInfoREST.dao.CourseInfoDAO;
import CoursesInfoREST.model.Course;
import CoursesInfoREST.model.CourseInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamzaghani on 15/12/2016.
 */
@Path("/xml/course")
public class CourseXML {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;


    @GET
    @Produces(MediaType.TEXT_XML)
    public Course getCourseInfoBrowserText() {
        Course course = new Course();
        List<CourseInfo> courseInfor = new ArrayList<CourseInfo>();
        courseInfor.addAll(CourseInfoDAO.instance.listCourse().values());
        course.setCourseInfos(courseInfor);
        return course;
    }
}
