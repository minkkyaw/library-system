package com.minkhantkyaw;

import java.util.Map;

public interface Document {
    int getID();

    String getDescription();

    void addSubmenu(int submenuID, SubMenu subMenu);

    Map<Integer, Document> getSubmenus();
}