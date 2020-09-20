package com.minkhantkyaw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Menu> Menus = new HashMap<Integer, Menu>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Menus.put(1, new Menu(1, "Explore the catalogue"));
        Menus.put(2, new Menu(2, "View your patron record"));
        Menus.put(3, new Menu(3, "Show you favourite books"));
        Menus.put(4, new Menu(4, "Enter Admin Mode"));

        Menus.get(4).addSubmenu(1, new SubMenu(1, "Add a patron"));
        Menus.get(4).addSubmenu(2, new SubMenu(1, "Remove a patron"));
        Menus.get(4).addSubmenu(3, new SubMenu(1, "Add a book to the catalogue"));
        Menus.get(4).addSubmenu(4, new SubMenu(1, "Remove a book from the catalogue"));
        Menus.get(4).addSubmenu(5, new SubMenu(1, "Remove a book from the catalogue"));


        System.out.println("Welcome to the Library! Please make a selection from the menu");
        for (int i = 1; i <= Menus.size(); i++) {
            System.out.println(i + ". " + Menus.get(i).getDescription());
        }
        System.out.println("X. Exit the system.");
        String input = scanner.nextLine().toUpperCase();
        if (isStringInt(input)) {
            Map<Integer, SubMenu> subMenus = Menus.get(Integer.parseInt(input)).getSubmenus();
            for (int i = 1; i <= Menus.size(); i++) {
                System.out.println(i + ". " + subMenus.get(i).getDescription());

            }
            String input2 = scanner.nextLine().toUpperCase();
            if (isStringInt(input2)) {
                switch(Integer.parseInt(input2)) {
                    case 1:
                        System.out.println("Enter Item ID(Number)");
                        int itemID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Item Name(String)");
                        String name = scanner.nextLine();
                        subMenus.get(Integer.parseInt(input2)).addItem(itemID, new Item(itemID, name));
                        break;
                    default:
                        break;
                }
            } else System.out.println("Exit the system.");
        } else System.out.println("Exit the system.");
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
