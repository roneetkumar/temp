import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel jobLabel;
    private JTextField nameField;
    private JTextField jobField;

    private JButton submitBtn;


    FormPanel(){
        Dimension dimension = getPreferredSize();
        dimension.width = 250;
        setPreferredSize(dimension);

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border fullBorder = BorderFactory.createCompoundBorder(outerBorder,innerBorder);
        setBorder(fullBorder);

        // setBorder(BorderFactory.createTitledBorder("Form"));


        //Object

        nameLabel = new JLabel("Name: ");
        jobLabel = new JLabel("Job: ");

        nameField = new JTextField(10);
        jobField = new JTextField(10);

        submitBtn = new JButton("Submit");


        




    }

}
