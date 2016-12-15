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
 */
@Path("/text/course")
public class CourseText {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStaffInfoBrowserText() {
        List<CourseInfo> courseInfo = new ArrayList<CourseInfo>();
        courseInfo.addAll(CourseInfoDAO.instance.queryGoogleDatastore().values());
        return courseInfo.toString();
    }
}
