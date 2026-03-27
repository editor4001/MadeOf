package com.physics;

import com.physics.components.Component;
import com.physics.components.GraphicsComponent;

import java.awt.*;
import java.util.ArrayList;

public class PhysicsObject {

    private boolean canHavePhysics;
    private double internalX;
    private double internalY;
    private double internalXVelocity;
    private double internalYVelocity;
    private boolean isPreRender;
    protected boolean canCollide = false;
    protected ArrayList<PhysicsObject> collidingObject;
    protected boolean isCeilled;
    protected double restitution = 0;
    protected double friction = 0;

    protected ArrayList<com.physics.components.Component> components = new ArrayList<>();

    public PhysicsObject(boolean canHavePhysics, boolean isPreRender,boolean isCeilled) {
        this.canHavePhysics = canHavePhysics;
        this.isPreRender = isPreRender;
        this.isCeilled = isCeilled;
    }

    public void setRestitution(double restitution) {
        this.restitution = restitution;
    }
    public void setFriction(double friction) {
        this.friction = friction;
    }

    public void addComponent(Component component) {
        for (Component c : components) {
            if (c.getClass().equals(component.getClass())) {
                return; // déjà un composant de ce type
            }
        }
        components.add(component);
    }

    public void removeComponent(com.physics.components.Component component) {
        components.remove(component);
    }

    protected void getUpdate(double deltaTime){
        if (canHavePhysics) {
            PhysicsHelper helper =
                    new PhysicsHelper(internalX, internalY, internalXVelocity, internalYVelocity);

            ArrayList<Double> positions = helper.nextPos();
            internalX = positions.get(0);
            internalY = positions.get(1);
        }

        // appliquer le mouvement avec deltaTime
        internalX += internalXVelocity * deltaTime;
        internalY += internalYVelocity * deltaTime;

        if(isPreRender){
            components.add(new GraphicsComponent(20,0));
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

    public boolean haveCollision(){
        return this.canCollide;
    }

    public void addCollision(PhysicsObject object){
        collidingObject.add(object);
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