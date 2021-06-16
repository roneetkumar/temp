import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String job;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String job){
        super(source);
        this.name = name;
        this.job = job;
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
}
