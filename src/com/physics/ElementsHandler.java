package com.physics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ElementsHandler extends JPanel {

    protected static ArrayList<Object> objects = new ArrayList<>();
    protected static ArrayList<Object> PreRenderObjects = new ArrayList<>();

    public ElementsHandler() {
        Timer timer = new Timer(16, e -> updateObjects());
        timer.start();
    }

    private void updateObjects() {
        for (Object o : objects) {
            o.getUpdate();
        }
        repaint();
    }

    public static void addObject(Object object) {
        objects.add(object);
        if (object.isPreRender()){
            PreRenderObjects.add(object);
        }
    }

    public static void removeObject(Object object) {
        objects.remove(object);
    }

    public static ArrayList<Object> getObjects() {
        return objects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object o : objects) {
            o.render(g);
        }
        for (Object o : PreRenderObjects) {
            int drawX = (int) o.getInternalX();
            int drawY = (int) o.getInternalY();
            g.fillOval(drawX, drawY, 20, 20);
        }
    }
}