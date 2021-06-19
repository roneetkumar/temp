package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Toolbar extends JPanel implements ActionListener {

    ArrayList<JButton> buttons = new ArrayList<>();

    private StringListener textListener;

    Toolbar(){
        setBorder(BorderFactory.createEtchedBorder());

        buttons.add(new JButton("Hello"));
        buttons.add(new JButton("GoodBye"));
        buttons.add(new JButton("Button"));

        for (JButton button: buttons) {
            button.setBackground(Color.white);
            button.addActionListener(this);
            add(button);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.DARK_GRAY);
    }

    public void setStringListener(StringListener textListener){
        this.textListener=textListener;
    }

    public void changeColor(Color color){
        setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (this.textListener!=null){
            switch (clicked.getText()){
                case "Hello":
                    this.textListener.sendText("Hello\n");
                    break;
                case "GoodBye":
                    this.textListener.sendText("GoodBye\n");
                    break;
                case "Button":
                    this.textListener.sendText("Button\n");
                    break;
                default:break;
            }
        }
    }
}
