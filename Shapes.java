import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Shapes extends Applet implements ItemListener,MouseListener{
    Choice col,shape;
    TextField t1,t2,t3;
    Color c;
    int x,y,width,height,radius,d=1;
        public void init(){
            c=new Color(0,0,0);
            col=new Choice();
            shape=new Choice();
            col.add("Blue");
            col.add("Green");
            col.add("Red");
            col.add("Black");
            shape.add("Rectangle");
            shape.add("Circle");
            add(col);
            add(shape);
            t1=new TextField(5);
            t2=new TextField(5);
            t3=new TextField(5);
            add(t1);
            add(t2);
            add(t3);
            col.addItemListener(this);
            shape.addItemListener(this);
            addMouseListener(this);
        }
    
    public void itemStateChanged(ItemEvent e){
        if(shape.getSelectedItem().equals("Rectangle")){
            width=Integer.parseInt(t1.getText());
            height=Integer.parseInt(t2.getText());
            d=1;
            if(col.getSelectedItem().equals("Red")){
            c=new Color(255,0,0);
            }
            if(col.getSelectedItem().equals("Green")){
            c=new Color(0,255,0);
            }
            if(col.getSelectedItem().equals("Blue")){
            c=new Color(0,0,255);
            }
            if(col.getSelectedItem().equals("Black")){
            c=new Color(0,0,0);
            }
        repaint();
        }
        if(shape.getSelectedItem().equals("Circle")){
            radius=Integer.parseInt(t3.getText());
            d=0;
            if(col.getSelectedItem().equals("Red")){
            c=new Color(255,0,0);
            }
            if(col.getSelectedItem().equals("Green")){
            c=new Color(0,255,0);
            }
            if(col.getSelectedItem().equals("Blue")){
            c=new Color(0,0,255);
            }
            if(col.getSelectedItem().equals("Black")){
            c=new Color(0,0,0);
            }
        repaint();
        }
        
    }

    public void mouseClicked(MouseEvent e){
        x=e.getX();
        y=e.getY();
        repaint();
    }

    public void update(Graphics g){
        g.setColor(c);
        if(d==1)
           g.drawRect(x,y,width,height);
        if(d==0)
            g.drawOval(x,y,radius,radius);
    }

    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}


}

//<applet code="Shapes.class" height=300 width=300> </applet>