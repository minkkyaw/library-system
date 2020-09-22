package com.minkhantkyaw;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class SubMenu implements Document {
    private int menuID;
    private String description;

    public SubMenu(int menuID, String description) {
        this.menuID = menuID;
        this.description = description;
    }

    @Override
    public int getID() {
        return menuID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void addSubmenu(int submenuID, SubMenu subMenu) {
        System.out.println("Nothing doing");
    }

    @Override
    public Map<Integer, Document> getSubmenus() {
        return null;
    }


}
