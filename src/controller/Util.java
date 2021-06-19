package controller;

import java.util.ArrayList;

public class Util {

    public static String printList(ArrayList<String> list){
        String str = "";

        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);

            if (i != list.size() - 1){
                str += ", ";
            }else{
                str += ".";
            }
        }
        return str;
    }
}
