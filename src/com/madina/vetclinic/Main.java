package com.madina.vetclinic;

import com.madina.vetclinic.interfaces.Menu;
import com.madina.vetclinic.menu.MenuManager;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuManager();
        menu.run();
    }
}
