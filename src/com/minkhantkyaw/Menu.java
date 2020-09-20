package com.minkhantkyaw;

import sun.security.krb5.internal.crypto.Des;

import javax.management.Descriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Menu implements Document {
    private int menuID;
    private String description;
    private final Map<Integer, SubMenu> subMenus;

    public Menu(int menuID, String description) {
        this.menuID=menuID;
        this.description= description;
        this.subMenus = new HashMap<Integer, SubMenu>();
    }

    @Override
    public int getID() {
        return menuID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void addSubmenu(int submenuID, SubMenu subMenu) {
        subMenus.put(submenuID, subMenu);
    }

    public Map<Integer, SubMenu> getSubmenus() {
        return subMenus;
    }
}
