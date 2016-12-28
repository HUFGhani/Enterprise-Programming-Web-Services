/**
 * Created by hamzaghani on 14/12/2016.
 */

function getAllCourse() {
    var web_xml_address = "find-all-course";
    var format = document.getElementById("format").value;
    var address = web_xml_address + "?format=" + format;

    switch (format) {
        case "json":
            getJSONData(address);
            break;
        case "text":
            getTextData(address);
            break;
        case "xml":
            getXMlData(address)
            break;
    }
}

function getCourse(){
    var web_xml_address = "find-course";
    var course = document.getElementById("course").value;
    var format = document.getElementById("format1").value;
    var address = web_xml_address +"?coursename="+ course+ "&format=" + format;

    switch (format) {
        case "json":
            getJSONData(address);
            break;
        case "text":
            getTextData(address);
            break;
        case "xml":
            getXMlData(address)
            break;
    }

}


function sendXMLData() {
    var Name = document.getElementById("courseName").value;
    var Tutor = document.getElementById("courseTutor").value;
    var Credits = document.getElementById("courseCredits").value;
    var Duration = document.getElementById("courseDuration").value;

    var web_xml_address = "add-course";
    var xmlstr = 'xml=<?xml version="1.0" encoding="UTF-8"?>';
    xmlstr+= "<CourseInfo><course>";
    xmlstr+= "<courseName>"+ Name + "</courseName>";
    xmlstr+= "<courseTutor>"+Tutor +"</courseTutor>";
    xmlstr+= "<courseCredits>"+Credits +"</courseCredits>";
    xmlstr+= "<courseDuration>"+Duration +"</courseDuration>";
    xmlstr+= "</course></CourseInfo>";

    console.log(xmlstr);

    $.ajax({
        url: web_xml_address,
        processData: false,
        type: "POST",  // type should be POST
        data: xmlstr, // send the string directly
        success: function(response){
            alert(response);
        },
        error: function(response) {
            alert(response);
        }
    });
}

function getJSONData(address) {
    var finalTable;
    $.getJSON(address, function (result) {
        document.getElementById("result-region").innerHTML = "";
        finalTable = buildTables();
        $.each(result.CourseInfo, function (i, data) {
                finalTable += '<tr>' +
                    '<td>' + data.courseID + '</td>' +
                    '<td>' + data.courseName + '</td>' +
                    '<td>' + data.courseTutor + '</td>' +
                    '<td>' + data.courseCredits + '</td>' +
                    '<td>' + data.courseDuration + '</td></tr>'

        });
        finalTable += '</table>';
        $("#result-region").append(finalTable);

    });
}
function getTextData(address) {
    var finalTable;
    $.get(address, {format: "text"}, function (data) {
        document.getElementById("result-region").innerHTML = "";
        finalTable = buildTables();
        var rawdata = data.split(/\n+/);
        var dataArray = new Array();
        for (var i = 0; i < rawdata.length; i++) {
            if (rawdata[i].length > 1) {
                dataArray.push(rawdata[i].split("#||#"));
            }
        }
        for (var i = 0; i < dataArray.length; i++) {
            finalTable += "  <tr>";
            var row = dataArray[i];
            for (var j = 0; j < row.length; j++) {
                finalTable += "<td>" + row[j] + "</td>";
            }
            finalTable += "</tr>";
        }
        finalTable += '</table>';
        $("#result-region").append(finalTable);
    });
}

function getXMlData(address) {
    var finalTable;
    $.get(address, {format: "xml"}, function (data) {
        document.getElementById("result-region").innerHTML = "";
        finalTable = buildTables();
        $(data).find('course').each(function () {
            finalTable += '<tr>' +
                '<td>' + $(this).find('courseID').text() + '</td>' +
                '<td>' + $(this).find('courseName').text() + '</td>' +
                '<td>' + $(this).find('courseTutor').text() + '</td>' +
                '<td>' + $(this).find('courseCredits').text() + '</td>' +
                '<td>' + $(this).find('courseDuration').text() + '</td></tr>'
        });
        finalTable += '</table>';
        $("#result-region").append(finalTable);
    });
}

function buildTables() {
    var headings = ["Course ID", "Course", "Course Tutor", "Credits", "Duration (Year)"];
    return "<h3>Course Information:</h3>" + getTable(headings);
}

function getTable(headings) {
    var table = "<table>\n"
        + getTableHeadings(headings);
    return table;
}

function getTableHeadings(headings) {
    var firstRow = "  <tr>";
    for (var i = 0; i < headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    return firstRow;
}