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
 * class which inchange of genarateing the data foramts in JSON, XML and Text String  
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

    // wrap Course information in to XML format
    private String buildXMLResponse(HashMap<String, CourseInfo> courseInfoList) {
        Course course = new Course();
        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);
            course.setCourseInfo(courseInfo);
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

    private String buildJSONResponse(HashMap<String, CourseInfo> courseInfoList) {

        Course course = new Course();
        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);
        }
        course.setCourseInfo(courseInfo);
        try {
            Gson gson = new Gson();
            jsonString = gson.toJson(course);
        } catch (Exception e) {
            System.out.println(e);
        }
        return jsonString;
    }

    private String buildTextResponse(HashMap<String, CourseInfo> courseInfoList) {
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
            sortedDataText += " " + courseInfo.get(i).getCourseDuration();
            if (courseInfo.size() - i > 1) {
                sortedDataText += " " + "\n\n\n";
            }
        }
        return sortedDataText;
    }

    public String dataFormat(String format, HashMap <String, CourseInfo> courseInfoMap){
        String dataFormat = null;
        if (format.equalsIgnoreCase("json")) {
                 dataFormat = buildJSONResponse(courseInfoMap);
        }else if (format.equalsIgnoreCase("xml")) {
                   dataFormat = buildXMLResponse(courseInfoMap);
        }else if (format.equalsIgnoreCase("text")){
                  dataFormat =  buildTextResponse(courseInfoMap);
        }
        return dataFormat;
    }
    public String responseContentType(String format){
        String responseContentType = null;
        if (format.equalsIgnoreCase("json")) {
            responseContentType = "application/json";
        }else if (format.equalsIgnoreCase("xml")) {
            responseContentType =  "text/xml";
        }else if (format.equalsIgnoreCase("text")){
            responseContentType = "text/text";
        }

        return responseContentType;
    }
}
