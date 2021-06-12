import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton hello;
    private JButton goodbye;
    private JButton button;

    private StringListener textListener;


    Toolbar(){
        hello = new JButton("Hello");
        goodbye = new JButton("GoodBye");
        button = new JButton("Button");

        hello.addActionListener(this);
        goodbye.addActionListener(this);
        button.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(hello);
        add(goodbye);
        add(button);
    }

    public void setStringListener(StringListener textListener){
        this.textListener=textListener;
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
