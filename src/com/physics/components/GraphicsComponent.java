package com.physics.components;

import com.physics.Object;
import com.physics.components.Component;

import java.awt.Graphics;

public class GraphicsComponent implements Component {

    private final int size;
    private final int colorRGB;

    public GraphicsComponent(int size, int colorRGB) {
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void render(Graphics g, Object object) {
        g.setColor(new java.awt.Color(colorRGB));
        g.fillOval((int) object.getInternalX(), (int) object.getInternalY(), size, size);
    }
}