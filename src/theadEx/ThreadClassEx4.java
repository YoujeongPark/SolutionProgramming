package theadEx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadClassEx4 extends Thread{

    private String fileName;
    private String result;

    public ThreadClassEx4(String fileName) {
        this.fileName = fileName;
    }

    public void run(){
        FileOutputStream fout = null;
        String content = "Hello";

        try {
            fout = new FileOutputStream("./src/OUTPUT/" + fileName);
            fout.write(content.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                fout.close();
                result = fileName;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public String getResult(){
        return result;
    }

}
