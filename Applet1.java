import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Applet1 extends Applet{
    Font f;
    Color c;
    public void paint(Graphics g){
        f=new Font("Times new roman",Font.BOLD,200);
        c=new Color(0,200,0);
        g.setFont(f);
        g.setColor(c);
        g.drawString("Holy Sh*t",200,200);
    }
}
//<applet code="Applet1.class" height=300 width=300></applet>
