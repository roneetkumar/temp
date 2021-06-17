import java.util.ArrayList;
import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String job;
    private AgeCategory age;
    private String status;
    private ArrayList<String> langs = new ArrayList<>();

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(
            Object source,
            String name,
            String job,
            AgeCategory age,
            String status,
            ArrayList<String> langs

    ) {
        super(source);
        this.name = name;
        this.job = job;
        this.age = age;
        this.status = status;
        this.langs = langs;
    }

    private String printList(ArrayList<String> list){
        String str = "";

        for (int i = 0; i < list.size(); i++) {
            str += langs.get(i);

            if (i != list.size() - 1){
                str += ", ";
            }else{
                str += ".";
            }
        }
        return str;
    }


    @Override
    public String toString() {
        return "Name : "
                + name + "\nJob : "
                + job + "\nAge: "
                + age + "\nStatus: "
                + status + "\nLanguages: "
                + printList(langs)
                + "\n\n";
    }
}
