package view;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JTable {
    private JTable table;
    private PersonTableModel personTableModel;

    public TablePanel(){
        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setTableData(List<Person> people){
        personTableModel.setData(people);
    }

    public void refresh(){
        personTableModel.fireTableDataChanged();
    }

}
