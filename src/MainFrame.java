import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;


    MainFrame(){
        super("Hello World");
        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        // EVENT LISTENERS
        toolbar.setStringListener(new StringListener() {
            @Override
            public void sendText(String text) {
                textPanel.appendText(text);
            }
        });


        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventTrigger(FormEvent e) {
                String name = e.getName();
                String job = e.getJob();
                AgeCategory age = e.getAge();
                textPanel.appendText("Name : "
                        + name + "\nJob : "
                        + job + "\nAge: "
                        + age + "\n\n"
                );
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
