package com.example.TestingThings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/WochenberichtServlet")
public class WochenberichtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final WochenberichtService wochenberichtService = new WochenberichtService("localhost", "wochenberichte", "postgres", "password");

    public WochenberichtServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Wochenbericht wochenbericht = new Wochenbericht(request.getParameter("date"), request.getParameter("monday"), request.getParameter("tuesday"), request.getParameter("wednesday"), request.getParameter("thursday"), request.getParameter("friday"), request.getParameter("mondayHours"), request.getParameter("tuesdayHours"), request.getParameter("wednesdayHours"), request.getParameter("thursdayHours"), request.getParameter("fridayHours"));
        wochenberichtService.removeBerichtByDate(request.getParameter("date"));
        wochenberichtService.addBericht(wochenbericht);
        request.setAttribute("myBerichte", wochenberichtService.getBerichte());
        RequestDispatcher dispatcher = request.getRequestDispatcher("submitWochenberichtResponse.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}


