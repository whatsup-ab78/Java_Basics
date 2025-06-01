import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo1 extends Applet implements ItemListener {
    Choice languageList;
    String selected = "";

    public void init() {
        languageList = new Choice();

        languageList.add("C");
        languageList.add("C++");
        languageList.add("Java");
        languageList.add("Python");
        languageList.add("JavaScript");

        add(languageList);
        languageList.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        selected = "You selected: " + languageList.getSelectedItem();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(selected, 20, 100);
    }
}

/*
<applet code="ChoiceDemo1.class" width="400" height="200"></applet>
*/
