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
    protected double width;
    protected double height;
    protected boolean isGrounded = false;

    public ElementsHandler(double width,double height) {
        this.width = width;
        this.height = height;

        lastTime = System.nanoTime();

        Timer timer = new Timer(16, e -> updateObjects());
        timer.start();
    }

    private void updateObjects() {
        currentTime = System.nanoTime();

        double deltaTime = (currentTime - lastTime) / 1_000_000_000.0;

        lastTime = currentTime;

        for (PhysicsObject o : physicsObjects) {
            o.getUpdate(deltaTime);

            if (o.isCeilled) {

                double x = o.getInternalX();
                double y = o.getInternalY();

                double vx = o.getInternalXVelocity();
                double vy = o.getInternalYVelocity();

                int radius = 10; // si ton cercle fait 20px → rayon = 10
                double friction = o.friction; // ex : 0.9 ou 5 selon ton moteur
                double restitution = o.restitution; // ex : 0.8 pour rebond réaliste

                // LEFT
                if (x < 0) {
                    o.setInternalX(0);
                    o.setInternalXVelocity(-vx * restitution);
                }

                // RIGHT
                if (x + radius * 2 > width) {
                    o.setInternalX(width - radius * 2);
                    o.setInternalXVelocity(-vx * restitution);
                }

                // TOP
                if (y < 0) {
                    o.setInternalY(0);
                    o.setInternalYVelocity(-vy * restitution);
                }

                // BOTTOM
                if (y + radius * 2 > height) {
                    o.setInternalY(height - radius * 2);

                    // si la vitesse verticale est très faible → stop
                    if (Math.abs(vy) < 1) { // seuil à ajuster selon ton moteur
                        o.setInternalYVelocity(0);
                        isGrounded = true;
                    } else {
                        // rebond vertical
                        if(!isGrounded) {
                            o.setInternalYVelocity(-vy * restitution);
                        }
                    }

                    // friction horizontale au sol
                    vx *= (1 - friction * deltaTime);
                    if (Math.abs(vx) < 0.01) vx = 0;

                    o.setInternalXVelocity(vx);
                }
            }
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