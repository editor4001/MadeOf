package com.physics.components;

import java.awt.Graphics;

public interface Component {

    void update(com.physics.Object object);

    void render(Graphics g, com.physics.Object object);
}