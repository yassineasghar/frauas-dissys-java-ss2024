package com.asghar.frauas.dissys.six.servlets;

import com.asghar.frauas.dissys.six.base.Library;
import com.asghar.frauas.dissys.six.helpers.CC;
import com.asghar.frauas.dissys.six.helpers.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(CC.Route.homePage)
public class HomePage extends HttpServlet {
    public void init() {
        Library library = new Library(CC.libraryName);
        library.addBook("Java", "CS", "Available");
        library.addBook("C++", "ML", "Yassine");
        library.addBook("Python", "DEV", "Tobias");
        library.addBook("SWED", "ENG", "Yassine");
        getServletContext().setAttribute(CC.libraryName, library);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();
        Helper.insertPageHeader(responseWriter);
        Helper.insertTasks(responseWriter);
        Helper.closeHtmlDocument(responseWriter);
    }
}
