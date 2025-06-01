import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CalcApplet extends Applet implements ItemListener {
    TextField t1, t2, result;
    Choice operations;

    public void init() {
        setLayout(null);

        Label l1 = new Label("First Number:");
        Label l2 = new Label("Second Number:");
        Label l3 = new Label("Result:");

        t1 = new TextField();
        t2 = new TextField();
        result = new TextField();
        result.setEditable(false);

        operations = new Choice();
        operations.add("ADD");
        operations.add("SUBTRACT");
        operations.add("MULTIPLY");
        operations.add("DIVIDE");
        operations.add("CLOSE");

        // Set bounds
        l1.setBounds(30, 30, 100, 20);
        t1.setBounds(140, 30, 100, 20);

        l2.setBounds(30, 60, 100, 20);
        t2.setBounds(140, 60, 100, 20);

        l3.setBounds(30, 90, 100, 20);
        result.setBounds(140, 90, 100, 20);

        operations.setBounds(30, 130, 210, 20);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(result);
        add(operations);

        operations.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        try {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());

            String op = operations.getSelectedItem();

            switch (op) {
                case "ADD":
                    result.setText(Integer.toString(a + b));
                    break;
                case "SUBTRACT":
                    result.setText(Integer.toString(a - b));
                    break;
                case "MULTIPLY":
                    result.setText(Integer.toString(a * b));
                    break;
                case "DIVIDE":
                    if (b != 0)
                        result.setText(Double.toString((double) a / b));
                    else
                        result.setText("Divide by zero!");
                    break;
                case "CLOSE":
                    result.setText("Closing...");
                    break;
            }
        } catch (Exception ex) {
            result.setText("Invalid Input");
        }
    }
}

/*
<applet code="CalcApplet.class" width="400" height="300"></applet>
*/
