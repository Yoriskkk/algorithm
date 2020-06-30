package com.demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemove {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(5)) {
                list.remove(i);
            }
        }*/
        for (Object obj : list) {
            if (obj.equals(6))
                list.remove(obj);
        }
        System.out.println(list.toString());

    }


}
