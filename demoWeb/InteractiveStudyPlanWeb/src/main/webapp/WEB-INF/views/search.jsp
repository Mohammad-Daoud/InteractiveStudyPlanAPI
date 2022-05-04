<%--
  Created by IntelliJ IDEA.
  User: mdss4
  Date: 3/19/2022
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>
<form action="/search" method="POST">
    <h2>Search for study plan</h2>

    &emsp; <label for="schoolName">School Name:  </label>
    <input name="schoolName" userType="text" placeholder="School Name" id="schoolName">
    <br/> <br/>
    &emsp; <label for="department">Department:  </label>
    <input name="department" userType="text" placeholder="Department" id="department">
    <br/> <br/>
    &emsp; <label for="year">Year:  </label>
    <input name="year" userType="number" min="2000" placeholder="year (after 2000) " id="year">
    <br/> <br/>
    &emsp;&emsp; &emsp; <button style="color: green" userType="submit"> search</button>
    &ensp; <button style="color: red" userType="reset"> clear </button>


</form>
</body>
</html>
