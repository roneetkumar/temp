package view;

import model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> personList;

    private String[] colNames = {"ID","Name","Job","Employment Category", "Age", "Gender", "Languages"};

    public PersonTableModel () { }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData (List<Person> list) {
        this.personList = list;
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Person p = personList.get(rowIndex);

        switch (columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getJob();
            case 3:
                return p.getEmploymentCategory();
            case 4:
                return p.getAge();
            case 5:
                return p.getGender();
            case 6:
                return p.getLangs();
        }

        return null;
    }
}
