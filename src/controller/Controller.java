package controller;

import db.Database;
import model.Person;
import view.FormEvent;

import java.util.List;

public class Controller {

    Database db = new Database();

    public void addPerson(FormEvent fe){
        Person person = fe.getPerson();
        db.addPerson(person);
        System.out.println(db.getPeople());
    }

    public List<Person> getPeople(){
        return db.getPeople();
    }


}
