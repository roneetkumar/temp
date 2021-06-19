package view;

import model.EmploymentCategory;
import model.Gender;
import model.Person;

import java.util.ArrayList;
import java.util.EventObject;

public class FormEvent extends EventObject {

    private Person person;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(
            Object source,
            Person person
    ) {
        super(source);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
