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

@WebServlet(CC.Route.searchBook)
public class SearchBook extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Library library = (Library) context.getAttribute(CC.libraryName);

        String bookTitle = request.getParameter(CC.Param.title);
        Book book = library.searchForBookByTitle(bookTitle);

        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();

        Helper.insertPageHeader(responseWriter);
        if (book != null) {
            responseWriter.println("<h4> The requested book is found : </h4>");
            responseWriter.println("<table border='1'>");
            responseWriter.println("<tr><th>Field</th><th>Value</th></tr>");
            responseWriter.println("<tr><td>Title</td><td>" + book.getTitle() + "</td></tr>");
            responseWriter.println("<tr><td>Shelf Mark</td><td>" + book.getShelfMark() + "</td></tr>");
            responseWriter.println("<tr><td>State</td><td>" + book.getState() + "</td></tr>");
            responseWriter.println("</table>");
        } else {
            responseWriter.println("<h4> The requested book " + bookTitle + " is not found ! </h4>");
        }

        Helper.insertTasks(responseWriter);
        Helper.closeHtmlDocument(responseWriter);
    }

}
