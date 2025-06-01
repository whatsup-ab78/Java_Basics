import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ChoiceDemo extends Applet implements AdjustmentListener,ItemListener{
    TextField t1,t2;
    Scrollbar s1;
    int x,y,z=0,value;
    Font f;
    Color c;
    Choice c1;
    //Button b1,b2,b3,b4;
    public void init(){
        t1=new TextField(5);
        t2=new TextField(5);
        s1=new Scrollbar(Scrollbar.HORIZONTAL,12,2,1,100);
        c1=new Choice();
        c1.add("Addition");
        c1.add("Substraction");
        c1.add("Multiplication");
        c1.add("Division");
        add(t1);   
        add(t2);    
        add(s1);    
        add(c1);    
        s1.addAdjustmentListener(this);
        c1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e){
        String select=c1.getSelectedItem();
        x=Integer.parseInt(t1.getText());
        y=Integer.parseInt(t2.getText());
        if(select=="Addition"){
            z=x+y;
            repaint();
        }
        if(select=="Substraction"){
            z=x-y;
            repaint();
        }
        if(select=="Multiplication"){
            z=x*y;
            repaint();
        }
        if(select=="Division"){
            z=x/y;
            repaint();
        }
    }

    public void adjustmentValueChanged(AdjustmentEvent e){
        value=s1.getValue();
        repaint();
    }

public void paint(Graphics g){
    if(z<100)
        c=new Color(0,255,0);
    else if(z==100)
        c=new Color(0,0,255);
    else
        c=new Color(255,0,0);
    f=new Font("Ariel",Font.BOLD,value);
    g.setColor(c);
    g.setFont(f);
    g.drawString("The Result is:"+z,500,500);

}




}
//<applet code="ChoiceDemo.class" height=300 width=300></applet>