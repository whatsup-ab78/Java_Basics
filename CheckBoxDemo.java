import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo extends Applet implements ItemListener {
    Checkbox c1, c2, c3;
    String msg = "";

    public void init() {
        c1 = new Checkbox("C++");
        c2 = new Checkbox("Java");
        c3 = new Checkbox("Python");

        add(c1);
        add(c2);
        add(c3);

        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        msg = "Selected: ";
        if (c1.getState()) msg += "C++ ";
        if (c2.getState()) msg += "Java ";
        if (c3.getState()) msg += "Python ";
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 150);
    }
}

/*
<applet code="CheckBoxDemo.class" width="400" height="200"></applet>
*/
