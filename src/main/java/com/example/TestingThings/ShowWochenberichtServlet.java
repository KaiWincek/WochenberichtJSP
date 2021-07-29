package com.example.TestingThings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShowWochenberichtServlet")
public class ShowWochenberichtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WochenberichtService wochenberichtService = new WochenberichtService("localhost", "wochenberichte", "postgres", "password");

    public ShowWochenberichtServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Wochenbericht aktuellerBericht = wochenberichtService.getBerichtByDate(request.getParameter("selectionDate"));
        request.setAttribute("date", aktuellerBericht.getDate());
        request.setAttribute("monday", aktuellerBericht.getMonday());
        request.setAttribute("mondayHours", aktuellerBericht.getMondayHours());
        request.setAttribute("tuesday", aktuellerBericht.getTuesday());
        request.setAttribute("tuesdayHours", aktuellerBericht.getTuesdayHours());
        request.setAttribute("wednesday", aktuellerBericht.getWednesday());
        request.setAttribute("wednesdayHours", aktuellerBericht.getWednesdayHours());
        request.setAttribute("thursday", aktuellerBericht.getThursday());
        request.setAttribute("thursdayHours", aktuellerBericht.getThursdayHours());
        request.setAttribute("friday", aktuellerBericht.getFriday());
        request.setAttribute("fridayHours", aktuellerBericht.getFridayHours());
        request.setAttribute("myBerichte", wochenberichtService.getBerichte());
        RequestDispatcher dispatcher = request.getRequestDispatcher("showWochenberichtResponse.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
