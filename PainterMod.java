import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PainterMod extends Applet implements AdjustmentListener,ActionListener,MouseListener,MouseMotionListener{
    TextField t1,t2,t3,t4;
    Scrollbar s1;
    int red,green,blue,ersize;
    Button draw,erase;
    Color c=new Color(255,255,255);
    int sx,sy,ex,ey,d=0;
    public void init(){
        t1=new TextField(5);
        t2=new TextField(5);
        t3=new TextField(5);
        draw=new Button("Draw");
        erase=new Button("Erase");
        s1=new Scrollbar(Scrollbar.VERTICAL,5,1,1,100);
        t4=new TextField(5);
        t4.setEnabled(false);
        add(t1);
        add(t2);
        add(t3);
        add(draw);
        add(erase);
        add(s1);
        add(t4);
        draw.addActionListener(this);
        erase.addActionListener(this);
        s1.addAdjustmentListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(draw)){
            d=1;
            red=Integer.parseInt(t1.getText());
            green=Integer.parseInt(t2.getText());
            blue=Integer.parseInt(t3.getText());
            repaint();
        }
        if(e.getSource().equals(erase)){
            d=0;
            repaint();
        }
    }

    public void adjustmentValueChanged(AdjustmentEvent e){
        ersize=s1.getValue();
        t4.setText(String.valueOf(ersize));
        repaint();
    }

    public void mousePressed(MouseEvent e){
        sx=ex=e.getX();
        sy=ey=e.getY();
    }

    public void mouseDragged(MouseEvent e){
        ex=e.getX();
        ey=e.getY();
        repaint();
    }

    public void update(Graphics g){
        if(d==1){
           c=new Color(red,green,blue);
           g.setColor(c);
           g.drawLine(sx,sy,ex,ey);
        }
        if(d==0){
            c=new Color(255,255,255);
            g.setColor(c);
            g.fillRect(sx,sy,ersize,ersize);
        }
        sx=ex;
        sy=ey;
    }

    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}
//<applet code="PainterMod.java" height=300 width=300></applet>