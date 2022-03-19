<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Study plan</title>
</head>
<body>
    <table border="1" style="margin: auto">
        <tr style="margin: auto">
            <td>Course ID</td>
            <td>Course Name</td>
            <td>Course Credit Hours</td>
            <td>Pre-Course</td>
            <td>Prerequisites</td>
        </tr>
        <c:forEach items="${plan}" var="show">
        <tr style="margin: auto">
                <td>${show.courseID}</td>
                <td>${show.courseName}</td>
                <td>${show.creditHours}</td>
                <td>${show.preCount}</td>
                <td>
                    <c:forEach items="${show.prerequisites}" var="preCourseView">
                        <p>${preCourseView}</p>
                    </c:forEach>
                </td>

        </tr>
        </c:forEach>
    </table>
</body>
</html>