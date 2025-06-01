import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseTextApplet extends Applet implements ActionListener, ItemListener, MouseListener {
    TextField inputField, redField, greenField, blueField;
    Button reverseButton;
    Choice fontSizeChoice;
    String reversedText = "";
    int fontSize = 16;
    Color fontColor = Color.BLACK;

    public void init() {
        setLayout(null);

        Label inputLabel = new Label("Enter Text:");
        inputLabel.setBounds(30, 20, 80, 20);
        add(inputLabel);

        inputField = new TextField(20);
        inputField.setBounds(120, 20, 200, 20);
        add(inputField);

        reverseButton = new Button("Reverse");
        reverseButton.setBounds(330, 20, 80, 20);
        reverseButton.addActionListener(this);
        reverseButton.addMouseListener(this);
        add(reverseButton);

        fontSizeChoice = new Choice();
        for (int i = 8; i <= 75; i += 4) {
            fontSizeChoice.add(String.valueOf(i));
        }
        fontSizeChoice.setBounds(30, 60, 100, 20);
        fontSizeChoice.addItemListener(this);
        add(fontSizeChoice);

        Label redLabel = new Label("R:");
        redLabel.setBounds(150, 60, 20, 20);
        add(redLabel);

        redField = new TextField("0", 3);
        redField.setBounds(170, 60, 40, 20);
        add(redField);

        Label greenLabel = new Label("G:");
        greenLabel.setBounds(220, 60, 20, 20);
        add(greenLabel);

        greenField = new TextField("0", 3);
        greenField.setBounds(240, 60, 40, 20);
        add(greenField);

        Label blueLabel = new Label("B:");
        blueLabel.setBounds(290, 60, 20, 20);
        add(blueLabel);

        blueField = new TextField("0", 3);
        blueField.setBounds(310, 60, 40, 20);
        add(blueField);
    }

    public void itemStateChanged(ItemEvent e) {
        fontSize = Integer.parseInt(fontSizeChoice.getSelectedItem());
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        String text = inputField.getText();
        reversedText = new StringBuilder(text).reverse().toString();
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {  // Right-click
            try {
                int r = Integer.parseInt(redField.getText());
                int g = Integer.parseInt(greenField.getText());
                int b = Integer.parseInt(blueField.getText());
                fontColor = new Color(r, g, b);
                repaint();
            } catch (Exception ex) {
                reversedText = "Invalid RGB values!";
                repaint();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(fontColor);
        g.setFont(new Font("Serif", Font.BOLD, fontSize));
        g.drawString(reversedText, 30, 150);
    }

    // Unused mouse events
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

/*
<applet code="ReverseTextApplet.class" width="500" height="300"></applet>
*/
