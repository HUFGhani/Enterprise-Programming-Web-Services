package builder;

import com.google.gson.Gson;
import dao.CourseInfoDAO;
import dao.CourseInfoInterface;
import model.CourseInfo;

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

        for (CourseInfo info : courseInfoList.values()) {
            courseInfo.add(info);


        }

        String sortedDataText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        sortedDataText = "<courses>\n";
        for (int i = 0; i < courseInfo.size(); i++) {

            sortedDataText += "\t<course>\n";
            sortedDataText += "\t\t<id>" + courseInfo.get(i).getCourseID()
                    + "</id>\n";
            sortedDataText += "\t\t<title>" + courseInfo.get(i).getCourseName()
                    + "</title>\n";
            sortedDataText += "\t\t<tutor>" + courseInfo.get(i).getCourseTutor()
                    + "</tutor>\n";
            sortedDataText += "\t\t<credits>" + courseInfo.get(i).getCourseCredits()
                    + "</credits>\n";
            sortedDataText += "\t\t<duration>" + courseInfo.get(i).getCourseDuration()
                    + "</duration>\n";
            sortedDataText += "\t</course>";
            sortedDataText += "\n";

        }
        return sortedDataText += "</courses>";
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