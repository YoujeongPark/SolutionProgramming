import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public void consoleFileIO(String pwd){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void fileRead() throws IOException {
        //FileReader fr = new FileReader("E:\\01_github\\SolutionProgramming\\src\\txtEx.txt"); //절대 경로
        FileReader fr = new FileReader(".\\src\\txtEx.txt"); //상대 경로
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        for(int i=1 ;  (line = br.readLine())!= null ; i++){
            System.out.println(line);
        }
    }

    public void fileWrite() throws IOException {
        File file = new File(".\\src\\newText.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(int i=0 ; i<100; i++){
            bw.append(String.valueOf(Math.random()*1000));
            bw.append("\n");
        }
        bw.close();
    }

    public void fileReadAll() throws IOException {
        Path path = Paths.get(".\\src\\txtEx.txt");
        Charset cs = StandardCharsets.UTF_8;
        List<String> stringList = new ArrayList<String>();
        stringList = Files.readAllLines(path,cs);
        for(String readLine : stringList){
            System.out.println(readLine);
        }

    }



}
