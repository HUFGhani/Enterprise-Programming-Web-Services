package controller;

import dao.CourseInfoDAO;
import dao.CourseInfoInterface;
import model.CourseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by hamzaghani on 12/12/2016.
 *this servlet allows the users to add Course to Datastore
 */
@WebServlet(name = "AddCourseServlet")
public class AddCourseServlet extends HttpServlet {

    public AddCourseServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JAXBContext jaxbContext;
        String xml = request.getParameter("xml");

        PrintWriter out = response.getWriter();
        final String responseMessage = "A Course has been successfully added to the GAE Datastore!";
        CourseInfo courseInfo = null;

        xml = xml.replaceAll("<CourseInfo>", "");
        xml = xml.replaceAll("</CourseInfo>", "");


        System.out.println(xml);

        try {
            jaxbContext = JAXBContext.newInstance(CourseInfo.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            courseInfo = (CourseInfo) unmarshaller.unmarshal(reader);
        } catch (JAXBException xmlParseException) {
            // Catches JAXB Exception
            xmlParseException.printStackTrace();
        }
        try {
            CourseInfoInterface courseInfoInterface = new CourseInfoDAO();
            courseInfoInterface.addCourse(courseInfo);
            out.print(responseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
