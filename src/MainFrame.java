import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton btn;
    private TextPanel textPanel;
    private Toolbar toobar;

    MainFrame(){
        super("Hello World");

        setLayout(new BorderLayout());

        btn = new JButton("Click");
        textPanel = new TextPanel();
        toobar = new Toolbar();


        // EVENT LISTENERS

        //toobar.setTextPanel();

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textPanel.appendText("Hello\n");
            }
        });

        add(toobar, BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);
        add(btn,BorderLayout.SOUTH);

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
