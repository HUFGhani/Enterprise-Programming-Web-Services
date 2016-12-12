package utility;

import com.google.gson.Gson;
import dao.CourseInfoDAO;
import dao.CourseInfoInterface;
import model.Course;
import model.CourseInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hamzaghani on 12/12/2016.
 */
public class ResponseBuilder {

    CourseInfoInterface courseInfoInterface = new CourseInfoDAO();
    HashMap<String, CourseInfo> courseInfoList = courseInfoInterface.listCourse();
    List<CourseInfo> courseInfo = new ArrayList<CourseInfo>();

    private  String xmlString;
    private String jsonString;
    private String sortedDataText = "";
    public ResponseBuilder() {

    }

    public String buildXMLResponse(HashMap<String, CourseInfo> courseInfoList) {


        Course course = new Course();
        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);

            course.setCourseInfos(courseInfo);
        }
        try {


        JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        StringWriter sw = new StringWriter();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(course, sw);

            xmlString = sw.toString();


        } catch (JAXBException e){
            System.out.println(e);
        }

        return xmlString;
    }

    public String buildJSONResponse(HashMap<String, CourseInfo> courseInfoList) {

        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);
        }

        try {

            Gson gson = new Gson();
            jsonString = gson.toJson(courseInfo);
        } catch (Exception e) {
            System.out.println(e);
        }

        return jsonString;
    }

    public String buildTextResponse(HashMap<String, CourseInfo> courseInfoList) {
        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);
        }

        for (int i = 0; i < courseInfo.size(); i++) {

            sortedDataText += " " + courseInfo.get(i).getCourseID()
                    + "#||#";
            sortedDataText += " " + courseInfo.get(i).getCourseName()
                    + "#||#";
            sortedDataText += " " + courseInfo.get(i).getCourseTutor()
                    + "#||#";
            sortedDataText += " " + courseInfo.get(i).getCourseCredits()
                    + "#||#";
            sortedDataText += " " + courseInfo.get(i).getCourseDuration()
                    + "#||#";


            if (courseInfo.size() - i > 1) {
                sortedDataText += " " + "\n\n\n";
            }
        }
        return sortedDataText;
    }
}