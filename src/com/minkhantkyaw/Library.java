package com.minkhantkyaw;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, Patron> patrons;
    private final Map<Integer, Book> books;
    private final Map<Integer, Document> menus;

    public Library() {
        this.menus = new HashMap<>();
        this.patrons = new HashMap<>();
        this.books = new HashMap<>();
    }

    public Map<Integer, Document> getMenus() {
        return menus;
    }

    public Map<Integer, Patron> getPatrons() {
        return patrons;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void addMenu(int menuID, String description) {
        if (menus.get(menuID) == null) {
            menus.put(menuID, new Menu(menuID, description));
            System.out.println(menuID + ". " + description + " is successfully added.");
        } else {
            System.out.println("Menu ID " + menuID + " is in used.");
        }
    }

    public void removeMenu(int menuID) {
        Document menu = menus.get(menuID);
        if (menu == null) {
            System.out.println("No menu found");
        } else {
            patrons.remove(menuID);
            System.out.println("Menu ID " + menuID + ". " + menu.getDescription() + " is successfully removed.");
        }
    }

    public void addSubmenu(int menuID, int submenuID, String submenuDescription) {
        if (menus.get(menuID).getSubmenus().get(submenuID) == null) {
            menus.get(menuID).addSubmenu(submenuID, new SubMenu(submenuID, submenuDescription));
            System.out.println(submenuID + ". " + submenuDescription + " is successfully added to menuID " + menuID + ".");
        } else {
            System.out.println("Submenu ID " + submenuID + " is in used for menuID " + menuID);
        }
    }

    public void removeSubmenu(int menuID, int submenuID) {
        Document submenu = menus.get(menuID).getSubmenus().get(submenuID);
        if (submenu == null) {
            System.out.println("No submenu found from the menuID " + menuID + ".");
        } else {
            patrons.remove(menuID);
            System.out.println("Submenu ID " + submenuID + ". " + submenu.getDescription() + " is successfully added to menuID " + menuID + ".");
        }
    }


    public void addPatron(int patronID, String patronName) {
        if (patrons.get(patronID) == null) {
            patrons.put(patronID, new Patron(patronID, patronName));
            System.out.println(patronID + ". " + patronName + " is successfully added.");
        } else {
            System.out.println("Patron ID " + patronID + " is in used.");
        }
    }

    public void removePatron(int patronID) {
        Patron patron = patrons.get(patronID);
        if (patron == null) {
            System.out.println("No patron found");
        } else {
            patrons.remove(patronID);
            System.out.println("Patron ID " + patronID + ". " + patron.getName() + " is successfully removed.");
        }
    }

    public void addBook(int bookID, String title, String author, String genre) {
        if (books.get(bookID) != null) {
            System.out.println("Book ID " + bookID + " is in used.");
        } else {
            books.put(bookID, new Book(bookID, title, author, genre));
            System.out.println("Book ID " + bookID + ". " + title + " is successfully added.");
        }
    }

    public void removeBook(int bookID) {
        Book book = books.get(bookID);
        System.out.println(book);
        if (book == null) {
            System.out.println("No book found");
        } else {
            books.remove(bookID);
            System.out.println("Book ID " + bookID + ". " + book.getTitle() + " is successfully removed.");
        }
    }

    public void borrowBook(int patronID, int bookID) {
        Patron patron = patrons.get(patronID);
        if (patron == null) {
            System.out.println("No patron found with this ID");
        } else {
            books.get(bookID).borrowBook(patronID);
            System.out.println("Book ID " + bookID + " has been borrowed by patron ID " + patronID);
        }
    }

    public void holdBook(int patronID, int bookID) {
        Patron patron = patrons.get(patronID);
        if (patron == null) {
            System.out.println("No patron found with this ID");
        } else {
            books.get(bookID).holdBook(patronID);
            System.out.println("Book ID " + bookID + " is hold by patron ID " + patronID);
        }
    }

    public void returnBook(int bookID) {
        books.get(bookID).returnBook();
        System.out.println("Book ID " + bookID + " has been returned");

    }
}
