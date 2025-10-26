package com.asghar.frauas.dissys.six.helpers;

import com.asghar.frauas.dissys.six.base.Library;
import jakarta.servlet.ServletContext;

import java.io.PrintWriter;

public class Helper {

    public static Library checkLibraryExistence(String libraryName, ServletContext context) {
        Library library = (Library) context.getAttribute(libraryName);

        if (library == null) {
            library = new Library(libraryName);
            context.setAttribute(libraryName, library);
        }

        return library;
    }

    public static void insertPageHeader(PrintWriter responseWriter) {
        responseWriter.println("<!DOCTYPE html>");
        responseWriter.println("<html>");
        responseWriter.println("<head>");
        responseWriter.println("<meta charset='UTF-8'>");
        responseWriter.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        responseWriter.println("<title>Library Management System</title>");
        responseWriter.println("<style>");
        responseWriter.println("body { font-family: Arial, sans-serif; }");
        responseWriter.println("h3 { color: #333; }");
        responseWriter.println("form { margin-bottom: 20px; }");
        responseWriter.println("</style>");
        responseWriter.println("</head>");
        responseWriter.println("<body>");
    }

    public static void insertSearchBookForm(PrintWriter responseWriter) {
        responseWriter.println("<h3>Search For Book By Title</h3>");
        responseWriter.println("<form action='SearchBook' method='POST'>");
        responseWriter.println("- Book Title | String : <input type='text' name='bookTitle' required><br>");
        responseWriter.println("<input type='submit' value='Search'>");
        responseWriter.println("</form>");
    }

    public static void insertAddNewBookForm(PrintWriter responseWriter) {
        responseWriter.println("<h3>Add New Book</h3>");
        responseWriter.println("<form action='AddBook' method='POST'>");
        responseWriter.println("- Book Title | String : <input type='text' name='bookTitle' required><br>");
        responseWriter.println("- Book Shelf Mark | String : <input type='text' name='bookShelfMark' required><br>");
        responseWriter.println("- Book State | String : <input type='text' name='bookState' required><br>");
        responseWriter.println("<input type='submit' value='Add'>");
        responseWriter.println("</form>");
    }

    public static void insertChangeBookStateForm(PrintWriter responseWriter) {
        responseWriter.println("<h3>Change Book State</h3>");
        responseWriter.println("<form action='ChangeState' method='POST'>");
        responseWriter.println("- Book Title | String : <input type='text' name='bookTitle' required><br>");
        responseWriter.println("- Book New State | String : <input type='text' name='bookNewState' required><br>");
        responseWriter.println("<input type='submit' value='Update'>");
        responseWriter.println("</form>");
    }

    public static void closeHtmlDocument(PrintWriter responseWriter) {
        responseWriter.println("</body>");
        responseWriter.println("</html>");
    }

    public static void insertTasks(PrintWriter responseWriter) {
        responseWriter.println("<h3>Select Task</h3>");
        responseWriter.println("<form action='Tasks' method='GET'>");
        responseWriter.println("<label><input type='radio' name='task' value='search' required> Search Book</label><br>");
        responseWriter.println("<label><input type='radio' name='task' value='add' required> Add New Book</label><br>");
        responseWriter.println("<label><input type='radio' name='task' value='show' required> Show Books</label><br>");
        responseWriter.println("<label><input type='radio' name='task' value='change' required> Change Book State</label><br>");
        responseWriter.println("<input type='submit' value='Submit'>");
        responseWriter.println("</form>");
    }
}
