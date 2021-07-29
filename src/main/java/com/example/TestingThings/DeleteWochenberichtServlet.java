package com.example.TestingThings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteWochenberichtServlet")
public class DeleteWochenberichtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WochenberichtService wochenberichtService = new WochenberichtService("localhost", "wochenberichte", "postgres", "password");

    public DeleteWochenberichtServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        wochenberichtService.removeBerichtByDate(request.getParameter("deleteDate"));
        request.setAttribute("myBerichte", wochenberichtService.getBerichte());
        RequestDispatcher dispatcher = request.getRequestDispatcher("submitWochenberichtResponse.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
