package com.physics;

import java.util.ArrayList;

public class physicsHelper {

    double x;
    double y;
    double xVelocity;
    double yVelocity;

    public physicsHelper(double x, double y, double XVelocity, double YVelocity){
        this.x = x;
        this.y = y;
        this.xVelocity = XVelocity;
        this.yVelocity = YVelocity;
    }

    public ArrayList<Double> nextPos(){
        double nextX = x + xVelocity;
        double nextY = y + yVelocity;
        ArrayList<Double> pos = new ArrayList<>();
        pos.add(nextX);
        pos.add(nextY);
        return pos;
    }
}
