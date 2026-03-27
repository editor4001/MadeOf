package com.physics.components;

import java.awt.*;
import com.physics.PhysicsObject;

public class RestitutionComponent implements Component {

    private double restitution; // ex : 0.5 pixels/tick²

    public RestitutionComponent(double restitution) {
        this.restitution = restitution;
    }


    @Override
    public void update(PhysicsObject physicsObject) {
        physicsObject.setRestitution(restitution);
    }

    @Override
    public void render(Graphics g, PhysicsObject physicsObject) {

    }
}