package com.physics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ElementsHandler extends JPanel {

    protected static ArrayList<PhysicsObject> physicsObjects = new ArrayList<>();
    protected static ArrayList<PhysicsObject> preRenderPhysicsObjects = new ArrayList<>();
    private long lastTime;
    private long currentTime;
    private double deltaTime;

    public ElementsHandler() {
        lastTime = System.nanoTime();

        Timer timer = new Timer(16, e -> updateObjects());
        timer.start();
    }

    private void updateObjects() {
        currentTime = System.nanoTime();

        double deltaTime = (currentTime - lastTime) / 1_000_000_000.0;

        lastTime = currentTime;

        for (PhysicsObject o : physicsObjects) {
            o.getUpdate();
        }
        repaint();
    }

    public static void addObject(PhysicsObject physicsObject) {
        physicsObjects.add(physicsObject);
        if (physicsObject.isPreRender()){
            preRenderPhysicsObjects.add(physicsObject);
        }
    }

    public static void removeObject(PhysicsObject physicsObject) {
        physicsObjects.remove(physicsObject);
    }

    public static ArrayList<PhysicsObject> getObjects() {
        return physicsObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PhysicsObject o : physicsObjects) {
            o.render(g);
        }
        for (PhysicsObject o : preRenderPhysicsObjects) {
            int drawX = (int) o.getInternalX();
            int drawY = (int) o.getInternalY();
            g.fillOval(drawX, drawY, 20, 20);
        }
    }
}