package controller;

import utility.ResponseBuilder;
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
 * this servlet is find coursename by name an send it to client 
 */
@WebServlet(name = "FindCourseByNameServlet")
public class FindCourseByNameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String courseName = request.getParameter("coursename");
        String format = request.getParameter("format");
        ResponseBuilder dataFormatResponse = new ResponseBuilder();
        String responseData = null;
        CourseInfoInterface courseInfoInterface = new CourseInfoDAO();
        HashMap<String, CourseInfo> courseInfoMap = courseInfoInterface.searchCourse(courseName);

        response.setContentType(dataFormatResponse.responseContentType(format).toString());
        response.setCharacterEncoding("UTF-8");
        responseData = dataFormatResponse.dataFormat(format,courseInfoMap);

        PrintWriter out = response.getWriter();
        out.print(responseData);

    }
}
