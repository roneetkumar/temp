package model;

import controller.Util;

import java.util.ArrayList;

public class Person {
    private static int count = 1;

    private Integer id;
    private String name;
    private String job;
    private AgeCategory age;
    private Gender gender;
    private EmploymentCategory employmentCategory;
    private ArrayList<String> langs = new ArrayList<>();

    public Person(
        String name,
        String job,
        AgeCategory age,
        Gender gender,
        EmploymentCategory employmentCategory,
        ArrayList<String> langs
    ) {
        this.id = count++;
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.employmentCategory = employmentCategory;
        this.langs = langs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public AgeCategory getAge() {
        return age;
    }

    public void setAge(AgeCategory age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public EmploymentCategory getEmploymentCategory() {
        return employmentCategory;
    }

    public void setEmploymentCategory(EmploymentCategory employmentCategory) {
        this.employmentCategory = employmentCategory;
    }

    public ArrayList<String> getLangs() {
        return langs;
    }

    public void setLangs(ArrayList<String> langs) {
        this.langs = langs;
    }

    @Override
    public String toString() {
        return  "ID: "
                + id + "\nName : "
                + name + "\nJob : "
                + job + "\nAge: "
                + age + "\nGender: "
                + gender + "\nStatus: "
                + employmentCategory + "\nLanguages: "
                + Util.printList(langs)
                + "\n\n";
    }

}
