package com.minkhantkyaw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Library library = new Library();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        library.addMenu(1, "Explore the catalogue");
        library.addMenu(2, "View your patron record");
        library.addMenu(3, "Show you favourite books");
        library.addMenu(4, "Enter Admin Mode");

        String[][] submenusForMenuIDs = {{"Display all books", "Display all available books", "Display all genres", "Display books in a genre", "Display all authors", "Display all books by an author", "Borrow a book", "Return a book", "Place a hold"}, null, null, {"Add a patron", "Remove a patron", "Add a book to the catalogue", "Remove a book from the catalogue"}};


        for (int i = 1; i <= library.getMenus().size(); i++) {

            if (submenusForMenuIDs[i - 1] != null)
                for (int j = 0; j < submenusForMenuIDs[i - 1].length; j++) {
                    library.addSubmenu(i, j + 1, submenusForMenuIDs[i - 1][j]);
                }

        }


        System.out.println("Welcome to the Library! Please make a selection from the menu");

        Map<Integer, Document> currentMenus = library.getMenus();
        int currentMenuNumber = 1;
        String category = "Menu";
        while (true) {
            System.out.println("");
            try {
                if (category == "Menu" || category == "Submenu") {
                    for (int i = 1; i <= currentMenus.size(); i++) {
                        System.out.println(i + ". " + currentMenus.get(i).getDescription());
                    }
                    if (category == "Submenu")
                        System.out.println("R. Return to the main menu.");
                    System.out.println("X. Exit the system.");
                }
                String input = scanner.nextLine();
                if (isStringInt(input)) {
                    if (category == "Menu") {
                        currentMenuNumber = Integer.parseInt(input);
                        currentMenus = currentMenus.get(currentMenuNumber).getSubmenus();
                        category = "Submenu";
                    } else if (category == "Submenu") {
                        Integer patronID = null;
                        Integer bookID = null;
                        String name = "";
                        int count = 0;
                        String patronIDInputLabel = "Enter patron ID";
                        String bookIDInputLabel = "Enter book ID";

                        switch (currentMenus.get(Integer.parseInt(input)).getDescription()) {
                            case "Display all books":
                                System.out.println("The Library has the following books:");
                                String splitter = "";
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    System.out.print(splitter + entry.getValue().getID() + ". " + entry.getValue().getTitle());
                                    splitter = ", ";
                                }
                                break;
                            case "Display all available books":
                                System.out.println("The following books are on the shelf:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    if (entry.getValue().isAvailability()) {
                                        System.out.println(entry.getValue().getID() + ". " + entry.getValue().getTitle());
                                    }
                                }
                                break;
                            case "Display all genres":
                                splitter = "";
                                System.out.println("The Library has books in the following genres:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    System.out.print(splitter + entry.getValue().getGenre());
                                    splitter = ", ";
                                }
                                break;
                            case "Display books in a genre":
                                splitter = "";
                                System.out.println("The following books in a genre:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    System.out.print(splitter + entry.getValue().getTitle());
                                    splitter = ", ";
                                }
                                break;
                            case "Display all authors":
                                splitter = "";
                                System.out.println("The following authors have books in this Library:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    System.out.print(splitter + entry.getValue().getAuthor());
                                    splitter = ", ";
                                }
                                break;
                            case "Borrow a book":
                                count = 0;
                                System.out.println("The following books are on the shelf:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    if (entry.getValue().isAvailability()) {
                                        count++;
                                        System.out.println(entry.getValue().getID() + ". " + entry.getValue().getTitle());
                                    }
                                }
                                if (count == 0)
                                    System.out.println("No Book available.");
                                else {
                                    patronID = inputNumberCheck(patronIDInputLabel);
                                    bookID = inputNumberCheck(bookIDInputLabel);
                                    library.borrowBook(patronID, bookID);
                                }
                                break;
                            case "Return a book":
                                count = 0;
                                patronID = inputNumberCheck(patronIDInputLabel);
                                System.out.println("The following books borrowed are :");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    if (entry.getValue().getPatronID() == patronID) {
                                        count++;
                                        System.out.println(entry.getValue().getID() + ". " + entry.getValue().getTitle());
                                    }
                                }
                                if (count == 0)
                                    System.out.println("No book borrowed");
                                else {
                                    bookID = inputNumberCheck(bookIDInputLabel);
                                    library.returnBook(bookID);
                                }
                                break;
                            case "Place a hold":
                                count = 0;
                                System.out.println("The following books are on the shelf:");
                                for (Map.Entry<Integer, Book> entry : library.getBooks().entrySet()) {
                                    if (entry.getValue().isAvailability()) {
                                        count++;
                                        System.out.println(entry.getValue().getID() + ". " + entry.getValue().getTitle());
                                    }
                                }
                                if (count == 0)
                                    System.out.println("No Book available.");
                                else {
                                    patronID = inputNumberCheck(patronIDInputLabel);
                                    bookID = inputNumberCheck(bookIDInputLabel);
                                    library.holdBook(patronID, bookID);
                                }
                                break;
                            case "Add a patron":

                                patronID = inputNumberCheck(patronIDInputLabel);
                                String patronNameInputLabel = "Enter patron name";
                                name = inputEmptyCheck(patronNameInputLabel, "Patron's name");
                                library.addPatron(patronID, name);
                                break;
                            case "Remove a patron":
                                patronID = inputNumberCheck(patronIDInputLabel);
                                library.removePatron(patronID);
                                break;
                            case "Add a book to the catalogue":
                                String title = "";
                                String author = "";
                                String genre = "";
                                bookID = inputNumberCheck(bookIDInputLabel);

                                String bookTitleInputLabel = "Enter the title of the book";
                                title = inputEmptyCheck(bookTitleInputLabel, "The title of the book");

                                String authorNameInputLabel = "Enter the author's name";
                                author = inputEmptyCheck(authorNameInputLabel, "The author's name");

                                String genreInputLabel = "Enter the genre";
                                genre = inputEmptyCheck(genreInputLabel, "The genre");
                                library.addBook(bookID, title, author, genre);
                                break;
                            case "Remove a book from the catalogue":
                                bookID = inputNumberCheck(bookIDInputLabel);
                                library.removeBook(bookID);
                                break;
                            default:
                                break;

                        }
                        System.out.println("");
                        currentMenus = library.getMenus().get(currentMenuNumber).getSubmenus();
                        category = "Submenu";
                    }
                } else if (input.equalsIgnoreCase("r")) {
                    System.out.println("Return to the main menu.");
                    currentMenus = library.getMenus();
                    category = "Menu";
                } else if (input.equalsIgnoreCase("x")) {
                    System.out.println("Exit the system.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("No Menu matched! Please type the menu number again!");
            }
        }

    }

    public static int inputNumberCheck(String inputLabel) {
        String input;
        System.out.println(inputLabel);
        while (true) {
            input = scanner.nextLine();
            if (isStringInt(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Please use the number ID!");
                System.out.println(inputLabel);
            }
        }
    }

    public static String inputEmptyCheck(String inputLabel, String inputTitle) {
        String input;
        System.out.println(inputLabel);
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("")) {
                System.out.println(inputTitle + " must not be empty!");
                System.out.println(inputLabel);

            } else {
                return input;
            }
        }
    }

    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
