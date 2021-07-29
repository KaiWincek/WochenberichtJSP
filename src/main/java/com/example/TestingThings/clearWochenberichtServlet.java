package com.example.TestingThings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clearWochenberichtServlet")
public class clearWochenberichtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WochenberichtService wochenberichtService = new WochenberichtService("localhost", "wochenberichte", "postgres", "password");

    public clearWochenberichtServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("date", " ");
        request.setAttribute("monday", " ");
        request.setAttribute("mondayHours", " ");
        request.setAttribute("tuesday", " ");
        request.setAttribute("tuesdayHours", " ");
        request.setAttribute("wednesday", " ");
        request.setAttribute("wednesdayHours", " ");
        request.setAttribute("thursday", " ");
        request.setAttribute("thursdayHours", " ");
        request.setAttribute("friday", " ");
        request.setAttribute("fridayHours", " ");
        request.setAttribute("myBerichte", wochenberichtService.getBerichte());
        RequestDispatcher dispatcher = request.getRequestDispatcher("showWochenberichtResponse.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
