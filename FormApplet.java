import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class FormApplet extends Applet implements ActionListener {
    Label nameLabel;
    TextField nameField;
    Button submitButton;
    String message = "";

    public void init() {
        setLayout(new FlowLayout());

        nameLabel = new Label("Enter your name:");
        nameField = new TextField(20);
        submitButton = new Button("Submit");

        add(nameLabel);
        add(nameField);
        add(submitButton);

        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        message = "Hello, " + nameField.getText() + "!";
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(message, 20, 100);
    }
}

//<applet code="FormApplet.java" width=400 height=200></applet>
