package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setJMenuBar(createMenuBar());

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
                textPanel.appendText(String.valueOf(e));
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // Menu
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu tools = new JMenu("Tools");

        // Menu Items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem settingsItem = new JMenuItem("Settings");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem gitItem = new JMenuItem("Git");
        JMenuItem commitItem = new JMenuItem("Commit");
        JMenuItem resetItem = new JMenuItem("Reset");

        JCheckBoxMenuItem isDarkItem = new JCheckBoxMenuItem("Dark Mode");
        JCheckBoxMenuItem isFormVisible = new JCheckBoxMenuItem("Show Form");
        isDarkItem.setSelected(true);
        isFormVisible.setSelected(true);

        isDarkItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isDarkItem.isSelected()){
                    toolbar.changeColor(Color.DARK_GRAY);
                }else{
                    toolbar.changeColor(Color.LIGHT_GRAY);
                }
            }
        });

        isFormVisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formPanel.setVisible(isFormVisible.isSelected());
            }
        });

        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.clearText();
            }
        });

        file.add(newItem);
        file.add(openItem);
        file.add(settingsItem);

        edit.add(cutItem);
        edit.add(copyItem);
        edit.add(pasteItem);
        edit.add(undoItem);
        edit.add(redoItem);
        edit.add(resetItem);

        tools.add(gitItem);
        tools.add(commitItem);

        view.add(tools);
        view.add(isDarkItem);
        view.add(isFormVisible);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);

        return menuBar;
    }
}
