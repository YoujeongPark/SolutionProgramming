package theadEx;

import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadClassEx5 extends Thread{

    private String fileName;
    private String result;

    public ThreadClassEx5(String fileName) {
        this.fileName = fileName;
    }

    public void finish(String name){
        System.out.println(name);
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
                finish(fileName);
                Thread.sleep(1000);

            }catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
