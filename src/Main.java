import com.physics.ElementsHandler;
import com.physics.PhysicsObject;
import com.physics.components.FrictionComponent;
import com.physics.components.GraphicsComponent;
import com.physics.components.GravityComponent;
import com.physics.components.RestitutionComponent;

import javax.swing.*;

public class Main {
    public static float counter = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);

        ElementsHandler handler = new ElementsHandler(800,565);

        PhysicsObject obj = new PhysicsObject(true,true,true);
        PhysicsObject obj2 = new PhysicsObject(true,true,true);
        ElementsHandler.addObject(obj);
        ElementsHandler.addObject(obj2);

        obj.addComponent(new GravityComponent(1));
        obj.addComponent(new RestitutionComponent(0.8));
        obj.addComponent(new FrictionComponent(0.99));
        obj.setInternalXVelocity(5);

        frame.add(handler);
        frame.setVisible(true);

        //work with border collision

    }
}