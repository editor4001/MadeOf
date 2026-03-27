# 🚀 MadeOf — Rework Version (Infdev)

---

## 🧠 Introduction

**MadeOf** is a lightweight **Physics Engine Library** designed to help developers easily add physics systems to their projects.

It is built to work with **javax.swing** — not for visuals (since Swing can look outdated), but because it is **simple, fast, and efficient** for development and testing.

---

## ⚙️ Core Concept

The new version of **MadeOf** is based on a modern approach:

* **Data-driven objects**
* **Component system**

This allows maximum flexibility and modularity.

---

## 🧩 Components System

Components are the **core of the engine**.

They allow you to add specific behaviors to an object, such as:

* Gravity
* Rendering
---
#### beta
* friction
* restitution
---
* (future: collisions, forces, etc.)

Each object can have **multiple components**, making the engine highly customizable.

You can also:

* Create your own components
* Share them with others

---

## 🔧 Current Components (Infdev)

At the moment, only a few components are available:

* **GraphicsComponent** → Handles how the object is rendered
* **GravityComponent** → Applies gravity to the object

⚠️ These are early implementations and may change.

---

## 💻 Example Usage

```java
import com.physics.ElementsHandler;
import com.physics.Object;
import com.physics.components.GraphicsComponent;
import com.physics.components.GravityComponent;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);

        // Engine handler (update + render loop)
        ElementsHandler handler = new ElementsHandler();

        // Main object (stores data + components)
        Object obj = new Object(true, false);

        // Register object in the engine
        ElementsHandler.addObject(obj);

        // Add components
        obj.addComponent(new GraphicsComponent(20, 0)); // rendering
        obj.addComponent(new GravityComponent(1));      // gravity

        frame.add(handler);
        frame.setVisible(true);
    }
}
```

---

## 🛣️ Roadmap (Planned Features)

* Multiple shapes (not only circles)
* Improved rendering system
* Forces & interactions
* More advanced component system (ECS-style)

---

## ⚠️ Warning

This project is currently in **Infdev (early development)**.

⚡ The API, structure, and features may change at any time.

---

## 🎯 Goal

The goal of **MadeOf** is to become a **simple, modular, and powerful physics engine** that is easy to use and extend.

---

## ❤️ Contributing

Contributions, ideas, and feedback are welcome!
If you want to contribute you can also contact me at : betotindustry@gmail.com
