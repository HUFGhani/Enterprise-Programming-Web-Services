/**
 * Created by hamzaghani on 14/12/2016.
 */

var headings = ["Course ID", "Course", "Course Tutor", "Credits", "Duration"];
var table = "<table border='1'>\n";



function getXMlData() {
    var firstRow = "  <tr>";
    var format = document.getElementById("format").value;
    var finalTable;

    for (var i = 0; i < headings.length; i++) {
        firstRow += "<th>" + headings[i] + "</th>";
    }
    firstRow += "</tr>\n";
    $.get('find-all-course?format=' + format, {format: format}, function (data) {
        finalTable = table + firstRow;
        $(data).find('course').each(function () {
         finalTable+='<tr>' +
                '<td>'+ $(this).find('courseID').text() + '</td>' +
                '<td>' + $(this).find('courseName').text() + '</td>' +
                '<td>' + $(this).find('courseTutor').text() + '</td>' +
                '<td>' + $(this).find('courseCredits').text() + '</td>' +
                '<td>' + $(this).find('courseDuration').text() + '</td></tr>'
        });
        finalTable+='</table>';
        $("#result-region").append(finalTable);
    });
}


