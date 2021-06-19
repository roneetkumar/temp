package db;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database(){
        people = new ArrayList<>();
    }

    public boolean addPerson(Person person){
        return people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }

}
