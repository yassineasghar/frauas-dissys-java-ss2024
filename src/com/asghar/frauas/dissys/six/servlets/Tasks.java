package com.asghar.frauas.dissys.six.servlets;

import com.asghar.frauas.dissys.six.helpers.CC;
import com.asghar.frauas.dissys.six.helpers.Helper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(CC.Route.tasks)
public class Tasks extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        Helper.checkLibraryExistence(CC.libraryName, context);

        String taskName = request.getParameter(CC.taskText);

        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();

        Helper.insertPageHeader(responseWriter);

        switch (taskName) {
            case CC.Task.searchTask:
                Helper.insertSearchBookForm(responseWriter);
                break;

            case CC.Task.addTask:
                Helper.insertAddNewBookForm(responseWriter);
                break;

            case CC.Task.changeTask:
                Helper.insertChangeBookStateForm(responseWriter);
                break;

            case CC.Task.getAllTask:
                response.sendRedirect(CC.Route.showBooks.replaceFirst("/", ""));
                break;

            default:
                response.sendRedirect(CC.Route.homePage.replaceFirst("/", ""));
        }
        Helper.closeHtmlDocument(responseWriter);
    }
}
