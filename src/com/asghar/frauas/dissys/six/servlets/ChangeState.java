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


@WebServlet(CC.Route.changeState)
public class ChangeState extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Library library = Helper.checkLibraryExistence(CC.libraryName, context);

        String bookTitle = request.getParameter(CC.Param.title);
        String bookNewState = request.getParameter(CC.Param.newState);

        Book book = library.searchForBookByTitle(bookTitle);

        response.setContentType(CC.contentType);
        PrintWriter responseWriter = response.getWriter();

        Helper.insertPageHeader(responseWriter);
        if (book != null) {
            String bookFormerState = book.getState();
            book.setState(bookNewState);
            Book updatedBook = library.searchForBookByTitle(bookTitle);

            String updatedState = updatedBook.getState();
            if (!bookFormerState.equals(updatedState) || updatedState.equals(bookNewState)) {
                responseWriter.println("<h4> The book state is updated from " + bookFormerState + " to " + updatedState + " </h4>");
            } else {
                responseWriter.println("<h4> Error changing book state from " + bookFormerState + " to " + updatedState + " </h4>");
            }
        } else {
            responseWriter.println("<h4> Cannot not change state of " + bookTitle + " because it does not exist ! </h4>");
        }
        Helper.insertTasks(responseWriter);
        Helper.closeHtmlDocument(responseWriter);
    }
}
