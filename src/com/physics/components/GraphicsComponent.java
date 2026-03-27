package com.physics.components;

import com.physics.PhysicsObject;

import java.awt.Graphics;

public class GraphicsComponent implements Component {

    private final int size;
    private final int colorRGB;

    public GraphicsComponent(int size, int colorRGB) {
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public void update(PhysicsObject physicsObject) {

    }

    @Override
    public void render(Graphics g, PhysicsObject physicsObject) {
        g.setColor(new java.awt.Color(colorRGB));
        g.fillOval((int) physicsObject.getInternalX(), (int) physicsObject.getInternalY(), size, size);
    }
}