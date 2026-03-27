import com.physics.ElementsHandler;
import com.physics.Object;
import com.physics.components.GraphicsComponent;
import com.physics.components.GravityComponent;

import javax.swing.*;

public class Main {
    public static Object obj = new Object(true,false);

    public static float counter = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);

        ElementsHandler handler = new ElementsHandler();

        ElementsHandler.addObject(obj);

        obj.addComponent(new GraphicsComponent(20,0));
        obj.addComponent(new GravityComponent(1));

        frame.add(handler);
        frame.setVisible(true);

    }
}