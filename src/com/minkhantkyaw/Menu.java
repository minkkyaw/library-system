package com.minkhantkyaw;

import javax.management.Descriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Menu implements Document {
    private int menuID;
    private String description;
    private final Map<Integer, Document> subMenus;

    public Menu(int menuID, String description) {
        this.menuID=menuID;
        this.description= description;
        this.subMenus = new HashMap<Integer, Document>();
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
        subMenus.put(submenuID, subMenu);
    }
    @Override
    public Map<Integer, Document> getSubmenus() {
        return subMenus;
    }
}
