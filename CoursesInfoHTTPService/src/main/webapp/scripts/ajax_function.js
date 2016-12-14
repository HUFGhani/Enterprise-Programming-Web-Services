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

function getCourse() {

}

function getJSONData(address) {
    var finalTable;
    $.getJSON(address, function (result) {
        document.getElementById("result-region").innerHTML = "";
        finalTable = buildTables();
        $.each(result, function (i, field) {
            //$("#result-region").append(field.courseID + " ");
            finalTable += '<tr>' +
                '<td>' + field.courseID + '</td>' +
                '<td>' + field.courseName + '</td>' +
                '<td>' + field.courseTutor + '</td>' +
                '<td>' + field.courseCredits + '</td>' +
                '<td>' + field.courseDuration + '</td></tr>'
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
    var table = "<table border='1'>\n"
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