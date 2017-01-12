package CoursesInfoREST.rest;

import CoursesInfoREST.dao.CourseInfoDAO;
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
 * to send json data
 */
@Path("/json/course")
public class CourseJSON {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseInfo> getCourseInfoBrowserText() {
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
        courseInfos.addAll(CourseInfoDAO.instance.listCourse().values());
        return courseInfos;
    }
}
