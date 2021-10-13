package main.java;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingClass {
    
    public void compareToExample(){
        String str1 = "ABC";
        String str2 = "ACB";
        System.out.println(str1.compareTo(str2)); // 두 문자의 차이

        String str3 = "BAA";
        String str4 = "ZAA";
        System.out.println(str3.compareTo(str4)); // 두 문자의 차이

    }

    public void charCompare(){
        char c = 'x';
        char d = 'y';
        System.out.println(c-d); // true
    }

    public void arraySorting(){
        int[] odds = {2, 3, 1, 7, 9};
        Arrays.sort(odds);
        System.out.println(Arrays.toString(odds)); // 오름차순

    }

    public void collectionsSorting(){
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aba");
        arrayList.add("ccc");
        arrayList.add("aaa");
        arrayList.add("bbb");

        Collections.sort(arrayList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);    // 오름차순 - 숫자로 무조건 반환
                                            // 만약에 거꾸로? -o1.compareTo(o2);
            }
        });

        System.out.println(arrayList.toString());
    }



}
