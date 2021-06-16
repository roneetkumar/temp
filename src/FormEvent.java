import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String job;
    private AgeCategory age;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(
            Object source,
            String name,
            String job,
            AgeCategory age
    ) {
        super(source);
        this.name = name;
        this.job = job;
        this.age = age;
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

    public AgeCategory getAge() {
        return age;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
