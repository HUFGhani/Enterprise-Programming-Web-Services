package controller;

import builder.ResponseBuilder;
import dao.CourseInfoDAO;
import dao.CourseInfoInterface;
import model.CourseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by hamzaghani on 12/12/2016.
 */
@WebServlet(name = "FindCourseByNameServlet")
public class FindCourseByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String courseName = request.getParameter("coursename");
        String format = request.getParameter("format");
        ResponseBuilder dataFormatResponse = new ResponseBuilder();
        String responseData = null;


        CourseInfoInterface courseInfoInterface = new CourseInfoDAO();


        HashMap<String, CourseInfo> courseInfoMap = courseInfoInterface.searchCourse(courseName);

        if (format.equalsIgnoreCase("json")) {
            responseData = dataFormatResponse.buildJSONResponse(courseInfoMap);
        }else if (format.equalsIgnoreCase("xml")) {
            responseData = dataFormatResponse.buildXMLResponse(courseInfoMap);
        }else if (format.equalsIgnoreCase("text")){
            responseData = dataFormatResponse.buildTextResponse(courseInfoMap);
        }
        PrintWriter out = response.getWriter();
        out.print(responseData);

    }
}
