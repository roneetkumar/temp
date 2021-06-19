package view;

import model.EmploymentCategory;
import model.Gender;
import model.Person;
import model.AgeCategory;
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
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderBtnGroup;

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
        ageModel.addElement(AgeCategory.CHILD);
        ageModel.addElement(AgeCategory.ADULT);
        ageModel.addElement(AgeCategory.SENIOR);
        ageList.setModel(ageModel);
        ageList.setSelectedIndex(0);
        ageList.setPreferredSize(new Dimension(100,100));
        ageList.setBorder(BorderFactory.createEtchedBorder());

        empBox = new JComboBox();
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement(EmploymentCategory.EMPLOYED);
        empModel.addElement(EmploymentCategory.SELF_EMPLOYED);
        empModel.addElement(EmploymentCategory.UNEMPLOYED);
        empBox.setModel(empModel);

        langEng = new JCheckBox();
        langFr = new JCheckBox();

        maleRadio = new JRadioButton();
        femaleRadio = new JRadioButton();
        genderBtnGroup = new ButtonGroup();

        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");


        genderBtnGroup.add(maleRadio);
        genderBtnGroup.add(femaleRadio);

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
        EmploymentCategory employmentCategory = (EmploymentCategory) empBox.getSelectedItem();
        ArrayList<String> langs = new ArrayList<>();


        try {
            String genderValue = genderBtnGroup.getSelection().getActionCommand();

            Gender gender = genderValue == "male"
                    ? Gender.MALE
                    : Gender.FEMALE;


            if (langEng.isSelected()) {
                langs.add("English");
            }

            if (langFr.isSelected()){
                langs.add("French");
            }

            Person p = new Person(name,job,age,gender,employmentCategory,langs);

            FormEvent fe = new FormEvent(e,p);

            if(formListener != null){
                formListener.formEventTrigger(fe);
                nameField.setText("");
                jobField.setText("");
                ageList.setSelectedIndex(0);
                empBox.setSelectedIndex(0);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(
                null,
                "Please select Gender!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

    }

    private void createLabel(JLabel label,GridBagConstraints gc, int anchor){
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = 0.1;
        gc.anchor = anchor;
        gc.insets = new Insets(0,0,0,5);
        add(label,gc);
    }

    private void createField(Component component,GridBagConstraints gc, int anchor){
        gc.gridx++;
        gc.weighty = 0.1;
        gc.anchor = anchor;
        gc.insets = new Insets(0,0,0,0);
        add(component,gc);
    }

    private void componentLayout() {
        // Layout
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        //        First Row
        createLabel(nameLabel, gc, GridBagConstraints.LINE_END);
        createField(nameField,gc,GridBagConstraints.LINE_START);


        //        Second Row
        createLabel(jobLabel, gc, GridBagConstraints.LINE_END);
        createField(jobField,gc,GridBagConstraints.LINE_START);

        //        Third Row
        createLabel(new JLabel("Age: "), gc, GridBagConstraints.FIRST_LINE_END);
        createField(ageList,gc,GridBagConstraints.LINE_START);

        //        Forth Row
        createLabel(new JLabel("Emp Status: "), gc, GridBagConstraints.LINE_END);
        createField(empBox,gc,GridBagConstraints.LINE_START);

        //        Fifth Row
        createLabel(new JLabel("English: "), gc, GridBagConstraints.LINE_END);
        createField(langEng,gc,GridBagConstraints.LINE_START);

        //        Sixth Row
        createLabel(new JLabel("French: "), gc, GridBagConstraints.LINE_END);
        createField(langFr,gc,GridBagConstraints.LINE_START);

        //        7th Row

        createLabel(new JLabel("Male: "), gc, GridBagConstraints.LINE_END);
        createField(maleRadio,gc,GridBagConstraints.LINE_START);

        //        8th Row
        createLabel(new JLabel("Female: "), gc, GridBagConstraints.LINE_END);
        createField(femaleRadio,gc,GridBagConstraints.LINE_START);

        //        Final Row
        gc.gridy++;
        gc.weighty = 2.0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitBtn,gc);
    }
}
