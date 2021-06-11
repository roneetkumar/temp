import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    private JButton hello;
    private JButton goodbye;

    Toolbar(){
        hello = new JButton("Hello");
        goodbye = new JButton("GoodBye");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(hello);
        add(goodbye);
    }
}
