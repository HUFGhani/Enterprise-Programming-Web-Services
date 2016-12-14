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

}


function sendXMLData() {

}

function getJSONData(address) {
    var finalTable;
    $.getJSON(address, function (result) {
        document.getElementById("result-region").innerHTML = "";
        finalTable = buildTables();
        $.each(result, function (i, data) {
            //$("#result-region").append(field.courseID + " ");
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
    var headings = ["Course ID", "Course", "Course Tutor", "Credits", "Duration"];
    return getTable(headings);
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