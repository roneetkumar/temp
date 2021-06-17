//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//public class test {
//
//    ArrayList<JCheckBox> langs = new ArrayList();
//
//    public void toSdtring() {
//
//            JCheckBox langEng = new JCheckBox();
//        JCheckBox langFr = new JCheckBox();
//        JCheckBox langMx = new JCheckBox();
//
//        langs.add(langEng);
//        langs.add(langFr);
//        langs.add(langMx);
//
//
//        // create list of checkboxes
//
//        // when user click on any checkbox
//            // check how many are checked
//            // if checked are more  than 5
//                // dont check the box i.e check.setEnabled(false);
//
//
//
//        for (JCheckBox check: langs) {
//            check.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                    int checked = 0;
//
//                    for (JCheckBox check:langs) {
//                            if (check.isSelected()){
//                                checked++;
//                            }
//                    }
//
//                    if (checked < 5){
//                        check.setEnabled(false);
//                    }
//
//                    System.out.println(checked);
//                }
//            });
//        }
//    }
//}
