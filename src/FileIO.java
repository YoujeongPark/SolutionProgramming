import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FileIO {

    public void currentDirectory(){ // 현재 경로
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
    }

    public int inputNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine()); //형변환
        return inputNumber;
    }

    public String inputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = String.valueOf(br.readLine()); //형변환
        return inputNumber;
    }


    public void fileRead() throws IOException {
        //FileReader fr = new FileReader("E:\\01_github\\SolutionProgramming\\src\\txtEx.txt"); //절대 경로
        FileReader fr = new FileReader(".\\src\\INPUT\\txtEx.txt"); //상대 경로
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        for(int i=1 ;  (line = br.readLine())!= null ; i++){
            System.out.println(line);
        }
    }

    public void fileWrite() throws IOException {
        File file = new File(".\\src\\OUTPUT\\DecimalData.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(int i=0 ; i<100; i++){
            bw.append(String.valueOf(Math.random()*1000));
            bw.append("\n");
        }
        bw.close();
    }

    public void fileReadAll() throws IOException {
        Path path = Paths.get(".\\src\\INPUT\\txtEx.txt");
        Charset cs = StandardCharsets.UTF_8;
        List<String> stringList = new ArrayList<String>();
        stringList = Files.readAllLines(path,cs);
        for(String readLine : stringList){
            System.out.println(readLine);
        }

    }

    public void fileReadAndWrite() throws IOException {
        //Read
        FileReader fr = new FileReader(".\\src\\INPUT\\txtEx.txt"); //상대 경로
        BufferedReader br = new BufferedReader(fr);

        //Write
        String newTextName = ".\\src\\OUTPUT\\nexText1";
        File file = new File(newTextName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        String line = "";
        for(int i=1 ;  (line = br.readLine())!= null ; i++) {
            bw.append(line + "#YN");
            bw.append("\n");
        }
        bw.close();
    }

    public void txtFileComparison(String path1, String path2){ // txt파일 2개 비교
        TreeMap<String, String> store = new TreeMap<String, String>();
        File file1 = new File(path1);
        File file2 = new File(path2);
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(file2));
            while(true){
                String str = bf.readLine();
                if(str == null)break;
                store.put(str, str);
            }

            bf = new BufferedReader(new FileReader(file1));
            while(true){
                String str = bf.readLine();
                if(str == null) break;
                String temp = store.get(str);
                if(temp == null){
                    System.out.println("다른문장 : " + str);
                }
            }
        }catch(IOException E){


        }

    }





}
