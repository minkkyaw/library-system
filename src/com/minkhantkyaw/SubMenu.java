package com.minkhantkyaw;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class SubMenu implements Document{
    private int menuID;
    private String description;
    private final Map<Integer, Item> items;

    public SubMenu(int menuID, String description) {
        this.menuID=menuID;
        this.description= description;
        this.items = new HashMap<Integer, Item>();
    }

    @Override
    public int getID() {
        return menuID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void addItem(int itemID, Item item) {
        items.put(itemID, item);

        for(int i = 1; i <= items.size(); i++) {
            System.out.println(i + ". " + items.get(i).getName() + " is successfully added.");
        }
    }

    public void removeItem(int itemID) {
        items.remove(itemID);
        System.out.println("Successfully removed");
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

}
