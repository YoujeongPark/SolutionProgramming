import java.io.*;

public class FileIO {

    public void consoleFileIO(String pwd){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public void fileIO() throws IOException {

        //FileReader fr = new FileReader("E:\\01_github\\SolutionProgramming\\src\\txtEx.txt");
        FileReader fr = new FileReader(".\\src\\txtEx.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        for(int i=1 ;  (line = br.readLine())!= null ; i++){
            System.out.println(line);
        }

    }


}
