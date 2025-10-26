package com.asghar.frauas.dissys.six.servlets;


import com.asghar.frauas.dissys.six.base.Book;
import com.asghar.frauas.dissys.six.base.Library;
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

@WebServlet(CC.Route.addBook)
public class AddBook extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Library library = Helper.checkLibraryExistence(CC.libraryName, context);

        String bookTitle = request.getParameter(CC.Param.title);
        String bookShelfMark = request.getParameter(CC.Param.shelfMark);
        String bookState = request.getParameter(CC.Param.state);

        library.addBook(bookTitle, bookShelfMark, bookState);

        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();

        Helper.insertPageHeader(responseWriter);

        Book book = library.searchForBookByTitle(bookTitle);
        if (book != null) {
            responseWriter.println("<h4>Book Added Successfully</h4>");
        } else {
            responseWriter.println("<h4>Failed to add Book, review your inputs:</h4>");
            responseWriter.println("<table border='1'>");
            responseWriter.println("<tr><th>Field</th><th>Value</th></tr>");
            responseWriter.println("<tr><td>Title</td><td>" + bookTitle + "</td></tr>");
            responseWriter.println("<tr><td>Shelf Mark</td><td>" + bookShelfMark + "</td></tr>");
            responseWriter.println("<tr><td>State</td><td>" + bookState + "</td></tr>");
            responseWriter.println("</table>");
        }

        Helper.insertTasks(responseWriter);
        Helper.closeHtmlDocument(responseWriter);
    }
}

