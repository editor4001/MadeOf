package com.physics.components;

import java.awt.*;
import com.physics.PhysicsObject;

public class FrictionComponent implements Component {

    private double friction; // ex : 0.5 pixels/tick²

    public FrictionComponent(double friction) {
        this.friction = friction;
    }


    @Override
    public void update(PhysicsObject physicsObject) {
        physicsObject.setFriction(friction);
    }

    @Override
    public void render(Graphics g, PhysicsObject physicsObject) {

    }
}