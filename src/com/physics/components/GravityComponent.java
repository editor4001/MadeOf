package com.physics.components;

import java.awt.*;
import com.physics.PhysicsObject;

public class GravityComponent implements Component {

    private double gravity; // ex : 0.5 pixels/tick²

    public GravityComponent(double gravity) {
        this.gravity = gravity;
    }


    @Override
    public void update(PhysicsObject physicsObject) {
        physicsObject.setInternalYVelocity(physicsObject.getInternalYVelocity() + gravity);
    }

    @Override
    public void render(Graphics g, PhysicsObject physicsObject) {

    }
}