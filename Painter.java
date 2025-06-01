import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Painter extends Applet implements MouseListener,MouseMotionListener,AdjustmentListener,ActionListener{
    Scrollbar s1,s2,s3;
    Button draw,erase;
    TextField t1,t2,t3;
    Color c;
    int sx,sy,ex,ey,d=1;
    int red,green,blue;
    
        public void init(){
            sx=sy=ex=ey=0;
            draw=new Button("Draw");
            erase=new Button("Erase");
            t1=new TextField(5);
            t2=new TextField(5);
            t3=new TextField(5);

            s1=new Scrollbar(Scrollbar.HORIZONTAL,5,10,3,255);
            s2=new Scrollbar(Scrollbar.HORIZONTAL,5,10,3,255);
            s3=new Scrollbar(Scrollbar.HORIZONTAL,5,10,3,255);
            c=new Color(0,0,0);
            add(draw);
            add(erase);
            add(t1);
            add(t2);
            add(t3);
            add(s1);
            add(s2);
            add(s3);
            s1.addAdjustmentListener(this);
            s2.addAdjustmentListener(this);
            s3.addAdjustmentListener(this);
            draw.addActionListener(this);
            erase.addActionListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(draw)){
                d=1;
                repaint();
            }
            if(e.getSource().equals(erase)){
                d=0;
                repaint();
            }

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

        public void adjustmentValueChanged(AdjustmentEvent e){
            red=s1.getValue();
            green=s2.getValue();
            blue=s3.getValue();
            c=new Color(red,green,blue);
            t1.setText(String.valueOf(red));
            t2.setText(String.valueOf(green));
            t3.setText(String.valueOf(blue));
            repaint();
        }

        public void update(Graphics g){
            if(d==1){
                g.setColor(c);
                g.drawLine(sx,sy,ex,ey);
            }
            if(d==0){
                c=new Color(255,255,255);
                g.setColor(c);
                g.fillRect(sx,sy,20,20);
            }
            sx=ex;
            sy=ey;

        }
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

}
//<applet code="Painter.java" height=300 width=300></applet>