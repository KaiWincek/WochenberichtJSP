<%@ page import="com.example.TestingThings.Wochenbericht" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wochenbericht</title>
    <style>
        <%@include file="main.css" %>
    </style>
</head>
<body>

<form action="WochenberichtServlet">
    <div class="grid-container">
        <div class="bericht">
            <h1 class="date">Date:</h1>
            <input class="datePicker" type="text" name="date" value="<%out.println(request.getAttribute("date"));%>"/>
            <p class="monday-container">
            <h1 class="weekday">Monday</h1>
            <textarea class="activities" type="text"
                      name="monday"><%out.println(request.getAttribute("monday"));%></textarea>
            <textarea class="hours" type="text"
                      name="mondayHours"><%out.println(request.getAttribute("mondayHours"));%></textarea>
            </p>
            <p class="tuesday-container">
            <h1 class="weekday">Tuesday</h1>
            <textarea class="activities" type="text"
                      name="tuesday"><%out.println(request.getAttribute("tuesday"));%></textarea>
            <textarea class="hours" type="text"
                      name="tuesdayHours"><%out.println(request.getAttribute("tuesdayHours"));%></textarea>
            </p>
            <p class="wednesday-container">
            <h1 class="weekday">Wednesday</h1>
            <textarea class="activities" type="text"
                      name="wednesday"><%out.println(request.getAttribute("wednesday"));%></textarea>
            <textarea class="hours" type="text"
                      name="wednesdayHours"><%out.println(request.getAttribute("wednesdayHours"));%></textarea>
            </p>
            <p class="thursday-container">
            <h1 class="weekday">Thursday</h1>
            <textarea class="activities" type="text"
                      name="thursday"><%out.println(request.getAttribute("thursday"));%></textarea>
            <textarea class="hours" type="text"
                      name="thursdayHours"><%out.println(request.getAttribute("thursdayHours"));%></textarea>
            </p>
            <p class="friday-container">
            <h1 class="weekday">Friday</h1>
            <textarea class="activities" type="text"
                      name="friday"><%out.println(request.getAttribute("friday"));%></textarea>
            <textarea class="hours" type="text"
                      name="fridayHours"><%out.println(request.getAttribute("fridayHours"));%></textarea>
            </p>
        </div>
        <input class="saveButton button" type="submit" value="Save"/>

        <div class="clear">
            <form action="clearWochenberichtServlet">
                <input class="clearButton button" type="submit" value="Clear"/>
            </form>
        </div>

        <div class="showBericht">
            <form action="ShowWochenberichtServlet">
                <input class="showButton button" type="submit" value="Show"/>
                <div>

                </div>
                <select class="showDropdown" name="selectionDate">
                    <c:forEach var="tempBericht" items="${myBerichte}">
                        <option>${tempBericht.getDate()}</option>
                    </c:forEach>
                </select>
            </form>
        </div>

        <div class="deleteBericht">
            <form action="DeleteWochenberichtServlet">
                <input class="deleteButton button" type="submit" value="Delete"/>
                <div>

                </div>
                <select class="deleteDropdown" name="deleteDate">
                    <c:forEach var="tempBericht" items="${myBerichte}">
                        <option>${tempBericht.getDate()}</option>
                    </c:forEach>
                </select>
            </form>
        </div>
    </div>
</form>
</body>
</html>