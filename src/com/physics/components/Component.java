package com.physics.components;

import com.physics.PhysicsObject;

import java.awt.Graphics;

public interface Component {

    void update(PhysicsObject physicsObject);

    void render(Graphics g, PhysicsObject physicsObject);
}