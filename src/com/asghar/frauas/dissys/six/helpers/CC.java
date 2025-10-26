package com.asghar.frauas.dissys.six.helpers;

/* CC = Constants Container */
/* Private constructor to avoid instantiation */

public class CC {

    private CC() {
    }

    public static final String libraryName = "fraUas";

    public static final String contentType = "text/html";
    public static final String taskText = "task";

    public static class Task {
        public static final String searchTask = "search";
        public static final String addTask = "add";
        public static final String changeTask = "change";
        public static final String getAllTask = "show";
    }

    public static class Route {
        public static final String homePage = "/HomePage";
        public static final String tasks = "/Tasks";
        public static final String searchBook = "/SearchBook";
        public static final String addBook = "/AddBook";
        public static final String showBooks = "/ShowBooks";
        public static final String changeState = "/ChangeState";
    }

    public static class Param {
        public static final String title = "bookTitle";
        public static final String shelfMark = "bookShelfMark";
        public static final String state = "bookState";
        public static final String newState = "bookNewState";
    }
}
