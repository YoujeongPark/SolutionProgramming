package main.java;
import java.util.*;
import java.sql.Array;
import java.util.StringTokenizer;

public class StringClass {

    public static String name = "Solution Program";

    public void showStringExample(){
        String str = "안녕하세요,로지,입니다.";
        String[] strArray= str.split(",");
        System.out.println(strArray[0]); // 안녕하세요
    }

    public String[] chgArrray(){
        String str = "안녕하세요,로지,입니다.";
        System.out.println(Arrays.stream(str.split("")).toList());
        return str.split("");
    }

    public void judgeLength() {
        String str = "안녕하세요";
        System.out.println(str.length()); // 일반 문자열일떄 length();

        String[] strArray = str.split(",");
        System.out.println(strArray.length); // Array일때 length

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.println(arrayList.size());// List일때 size()
    }

    public void stringCharAt(){
        String str = "안녕하세요";
        System.out.println(str.charAt(1)); // 녕
    }

    public void getIndex(){
        if(name.indexOf("P") >=0){
            System.out.println("P값 존재" + "위치 : " + name.indexOf("P"));
        }else{
            System.out.println("P값 존재하지 않음 ");
        }
    }

    public void getLength(){ // String 길이
        System.out.println(name.length());
    }

    public void getSubString(){ // String 일부 문자열 추출
        System.out.println(name.substring(0,4));
    }


    public void StringBuilderCFunc(){
        StringBuilder sb = new StringBuilder("Rosy");
        sb.append("Park");
        System.out.println(sb); //RosyPark
        System.out.println(sb.length()); //8
    }


    public void StringTokenizerCFunc() {
        String sb2 = "Biden finds his comfort/zone";
        StringTokenizer stk = new StringTokenizer(sb2);
        System.out.println(stk); //java.util.StringTokenizer@119d7047
        System.out.println(stk.countTokens());
        while(stk.hasMoreTokens()){
            System.out.println(stk.nextToken()); //단어출력...
        }

        String sb3 = "Biden finds his comfort/zone";
        StringTokenizer stk2 = new StringTokenizer(sb2,"/");
        System.out.println(stk2);
        System.out.println(stk2.countTokens()); //2
        while(stk2.hasMoreTokens()){
            System.out.println(stk2.nextToken()); //단어출력...
        }

        //출처 - https://ifuwanna.tistory.com/232
    }
}
