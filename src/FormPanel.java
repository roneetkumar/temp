import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel jobLabel;
    private JTextField nameField;
    private JTextField jobField;
    private JButton submitBtn;
    private JList ageList;
    private JComboBox empBox;
    private JCheckBox langEng;
    private JCheckBox langFr;

    private FormListener formListener;


    FormPanel(){
        Dimension dimension = getPreferredSize();
        dimension.width = 250;
        setPreferredSize(dimension);

        TitledBorder innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border fullBorder = BorderFactory.createCompoundBorder(outerBorder,innerBorder);

        innerBorder.setTitleJustification(TitledBorder.CENTER);

        setBorder(fullBorder);

        // setBorder(BorderFactory.createTitledBorder("Form"));


        //Object
        nameLabel = new JLabel("Name: ");
        jobLabel = new JLabel("Job: ");

        nameField = new JTextField(10);
        jobField = new JTextField(10);

        submitBtn = new JButton("Submit");

        submitBtn.addActionListener(this);

        ageList = new JList();
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18 to 65"));
        ageModel.addElement(new AgeCategory(2,"65 Above"));
        ageList.setModel(ageModel);
        ageList.setSelectedIndex(0);
        ageList.setPreferredSize(new Dimension(100,100));
        ageList.setBorder(BorderFactory.createEtchedBorder());

        empBox = new JComboBox();
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Un-Employed");
        empBox.setModel(empModel);

        langEng = new JCheckBox();
        langFr = new JCheckBox();

//        langEng.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                boolean isChecked = langEng.isSelected();
//                System.out.println(isChecked);
//                nameLabel.setEnabled(!isChecked);
//                nameField.setEnabled(!isChecked);
//            }
//        });

        componentLayout();
    }


    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String job = jobField.getText();
        AgeCategory age = (AgeCategory) ageList.getSelectedValue();
        String status = (String) empBox.getSelectedItem();
        ArrayList<String> langs = new ArrayList<>();

        if (langEng.isSelected()) {
            langs.add("English");
        }

        if (langFr.isSelected()){
            langs.add("French");
        }


        FormEvent fe = new FormEvent(e,name,job, age, status,langs);

        if(formListener != null){
            formListener.formEventTrigger(fe);
            nameField.setText("");
            jobField.setText("");
            ageList.setSelectedIndex(0);
            empBox.setSelectedIndex(0);
        }
    }

    private void componentLayout() {
        // Layout
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        //        First Row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel,gc);

        gc.gridx++;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField,gc);

        //        Second Row
        gc.gridx = 0;
        gc.gridy++;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(jobLabel,gc);

        gc.gridx++;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(jobField,gc);

        //        Third Row
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Age: "),gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList,gc);

        //        Forth Row
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Emp Status: "),gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(empBox,gc);

        //        Fifth Row
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("English: "),gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(langEng,gc);

        //        Sixth Row
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("French: "),gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(langFr,gc);

        //        Final Row
        gc.gridy++;
        gc.weighty = 2.0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitBtn,gc);
    }
}
