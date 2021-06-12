import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton hello;
    private JButton goodbye;
    private JButton button;

    private TextPanel textPanel;


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

    public void setTextPanel(TextPanel textPanel){
        this.textPanel=textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (this.textPanel!=null){
            switch (clicked.getText()){
                case "Hello":
                    this.textPanel.appendText("Hello\n");
                    break;
                case "GoodBye":
                    this.textPanel.appendText("GoodBye\n");
                    break;
                case "Button":
                    this.textPanel.appendText("Button\n");
                    break;
                default:break;
            }
        }


    }
}
