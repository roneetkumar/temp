import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;

    TextPanel(){
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        //setBackground(Color.BLUE);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }
}
