package CoursesInfoREST.rest;

import CoursesInfoREST.dao.CourseInfoDAO;
import CoursesInfoREST.model.CourseInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Created by hamzaghani on 15/12/2016.
 */
public class CourseHelper {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;

    public CourseHelper(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public CourseInfo getCourseInfoBrowserText() {
        CourseInfo courseInfo = CourseInfoDAO.instance.queryGoogleDatastore().get(id);
        if (courseInfo == null)
            throw new RuntimeException("Get: course with " + id + " not found");
        return courseInfo;
    }
}
