import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton hello;
    private JButton goodbye;

    Toolbar(){
        hello = new JButton("Hello");
        goodbye = new JButton("GoodBye");

        hello.addActionListener(this);
        goodbye.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(hello);
        add(goodbye);
    }

    public void setTextPanel(TextPanel textPanel){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        switch (clicked.getText()){
            case "Hello":
                System.out.println("Hello");
                break;
            case "GoodBye":
                System.out.println("GoodBye");
                break;
            default:break;
        }

    }
}
