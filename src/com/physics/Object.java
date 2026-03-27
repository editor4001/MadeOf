package com.physics;

import java.awt.*;
import java.util.ArrayList;

public class Object {

    private boolean canHavePhysics;
    private double internalX;
    private double internalY;
    private double internalXVelocity;
    private double internalYVelocity;
    private boolean isPreRender;

    protected static ArrayList<com.physics.components.Component> components = new ArrayList<>();

    public Object(boolean canHavePhysics,boolean isPreRender) {
        this.canHavePhysics = canHavePhysics;
        this.isPreRender = isPreRender;
    }


    public void addComponent(com.physics.components.Component component) {
        components.add(component);
    }

    public void removeComponent(com.physics.components.Component component) {
        components.remove(component);
    }


    protected void getUpdate(){
        if (this.canHavePhysics) {
            physicsHelper helper = new physicsHelper(internalX,internalY,internalXVelocity,internalYVelocity);
            ArrayList<Double> positions = helper.nextPos();
            internalX = positions.get(0);
            internalY = positions.get(1);
        }

        for (com.physics.components.Component component : components) {
            component.update(this);
        }
    }

    protected void render(Graphics g) {
        for (com.physics.components.Component component : components) {
            component.render(g,this);
        }
    }

    public boolean canHavePhysics() {
        return this.canHavePhysics;
    }

    public void setcanHavePhysics(boolean canHavePhysics) {
        this.canHavePhysics = canHavePhysics;
    }

    public double getInternalX() {
        return internalX;
    }

    public double getInternalY() {
        return internalY;
    }

    public double getInternalXVelocity() {
        return internalXVelocity;
    }

    public double getInternalYVelocity() {
        return internalYVelocity;
    }

    public void setInternalX(double internalX) {
        this.internalX = internalX;
    }
    public void setInternalY(double internalY) {
        this.internalY = internalY;
    }
    public void setInternalXVelocity(double internalXVelocity) {
        this.internalXVelocity = internalXVelocity;
    }
    public void setInternalYVelocity(double internalYVelocity) {
        this.internalYVelocity = internalYVelocity;
    }

    public boolean isPreRender() {
        return isPreRender;
    }
}