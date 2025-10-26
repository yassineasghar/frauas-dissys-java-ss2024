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
import java.util.Set;

@WebServlet(CC.Route.showBooks)
public class ShowBooks extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        Library library = Helper.checkLibraryExistence(CC.libraryName, context);
        Set<Book> books = library.getBooks();

        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();

        Helper.insertPageHeader(responseWriter);

        if (!books.isEmpty()) {
            responseWriter.println("<h4>Books found in " + CC.libraryName + ", are :</h4>");
            responseWriter.println("<table border='1'>");
            responseWriter.println("<tr><th>#</th><th>Title</th><th>Shelf Mark</th><th>State</th></tr>");

            int index = 1;
            for (Book book : books) {
                responseWriter.println("<tr>");
                responseWriter.println("<td>" + index++ + "</td>");
                responseWriter.println("<td>" + book.getTitle() + "</td>");
                responseWriter.println("<td>" + book.getShelfMark() + "</td>");
                responseWriter.println("<td>" + book.getState() + "</td>");
                responseWriter.println("</tr>");
            }
            responseWriter.println("</table>");
        } else {
            responseWriter.println("<h4>No Books found in " + CC.libraryName + " ! </h4>");
        }
        Helper.insertTasks(responseWriter);
        Helper.closeHtmlDocument(responseWriter);
    }

}
