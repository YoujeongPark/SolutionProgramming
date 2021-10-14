import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class ListMapClass {


    public void ListExample() throws IOException {

        ArrayList<Grade> arrayList = new ArrayList<>();

        try{

            BufferedReader bufferedReader = new BufferedReader(new FileReader("Sample.txt"));
            String str;

            while((str = bufferedReader.readLine())!= null){
                String words[] = str.split("");
                Grade grade = new Grade(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]))
                arrayList.add(grade);
            }
            bufferedReader.close();
        }catch(IOException e){
            System.err.println(e);
            System.exit(1);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String strInput = bufferedReader.readLine();
            if(strInput.equals("PRINT")){
                Collections.sort(arrayList, (g1, g2) -> g1.getName().compareTo(g2.getName()));
            }
            else if(strInput.equals("KOREAN")){
                Collections.sort(arrayList, (g1, g2) -> g1.getKorean() - g2.getKorean());
            }
            else if(strInput.equals("ENGLISH")){
                Collections.sort(arrayList, (g1, g2) -> g1.getEnglish() - g2.getEnglish());
            }
            else if(strInput.equals("MATH")){
                Collections.sort(arrayList, (g1, g2) -> g1.getMath() - g2.getEnglish());
            }
            else if(strInput.equals("QUIT")){
                break;
            }
        }

        Iterator<Grade> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Grade grade = iterator.next();
            System.out.println(String.format("%s %d %d %d", grade.getName(), grade.getKorean(), grade.getEnglish(), grade.getMath()));
        }



    }

    public void MapExample() throws IOException {

        HashMap<String, Effort> hashmap = new HashMap<String, Effort>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.csv"));
        String line;

        while((line = bufferedReader.readLine()) != null){
            String[] words = line.split(",");
            String key = words[1];

            if(!hashmap.containsKey(key)){
                Effort effort = new Effort(words[2], Double.parseDouble(words[3]), Double.parseDouble(words[4]), Double.parseDouble(words[5]));
                hashmap.put(key, effort);
            }else{
                hashmap.get(key).AddA(Double.parseDouble(words[3]));
                hashmap.get(key).AddB(Double.parseDouble(words[4]));
                hashmap.get(key).AddC(Double.parseDouble(words[5]));
            }
        }

        if(bufferedReader!= null){
            bufferedReader.close();
        }

        for(String key : hashmap.keySet()){
            double total = hashmap.get(key).getdA() + hashmap.get(key).getdB() +hashmap.get(key).getdC();
            System.out.println(String.format("%s %s %.1f %.1f -> %.1f", key,
                    hashmap.get(key).getStrName(),
                    hashmap.get(key).getdA(),
                    hashmap.get(key).getdB(),
                    hashmap.get(key).getdC(),
                    total
                    ));
        }




    }


}

class Effort{

    private String strName;
    private double dA;
    private double dB;
    private double dC;


    public Effort(String strName, double dA, double dB, double dC) {
        this.strName = strName;
        this.dA = dA;
        this.dB = dB;
        this.dC = dC;
    }


    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public double getdA() {
        return dA;
    }

    public void setdA(double dA) {
        this.dA = dA;
    }

    public double getdB() {
        return dB;
    }

    public void setdB(double dB) {
        this.dB = dB;
    }

    public double getdC() {
        return dC;
    }

    public void setdC(double dC) {
        this.dC = dC;
    }

    public void AddA(double d){
        dA += d;
    }

    public void AddB(double d){
        dB += d;
    }

    public void AddC(double d){
        dC += d;
    }



}




class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math;

    public Grade(String str, int korean, int english, int math) {
        strName = str;
        Korean = korean;
        English = english;
        Math = math;
    }


    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public int getKorean() {
        return Korean;
    }

    public void setKorean(int korean) {
        Korean = korean;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }



}