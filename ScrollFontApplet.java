import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollFontApplet extends Applet implements AdjustmentListener {
    Scrollbar fontSizeScroll;
    int fontSize = 20;
    String word = "Dynamic Text";

    public void init() {
        setLayout(null);

        fontSizeScroll = new Scrollbar(Scrollbar.HORIZONTAL, 20, 1, 8, 75);
        fontSizeScroll.setBounds(30, 50, 300, 20);
        fontSizeScroll.addAdjustmentListener(this);
        add(fontSizeScroll);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        fontSize = fontSizeScroll.getValue();
        repaint();
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.drawString(word, 30, 120);
        g.drawString("Font Size: " + fontSize, 30, 160);
    }
}

/*
<applet code="ScrollFontApplet.class" width="400" height="200"></applet>
*/
