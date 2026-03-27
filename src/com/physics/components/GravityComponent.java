package com.physics.components;

import java.awt.*;
import com.physics.Object;

public class GravityComponent implements Component {

    private double gravity; // ex : 0.5 pixels/tick²

    public GravityComponent(double gravity) {
        this.gravity = gravity;
    }


    @Override
    public void update(Object object) {
        object.setInternalYVelocity(object.getInternalYVelocity() + gravity);
    }

    @Override
    public void render(Graphics g, Object object) {

    }
}