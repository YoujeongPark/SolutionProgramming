import main.java.QueueStackClass;
import org.w3c.dom.ls.LSOutput;
import theadEx.ThreadClassEx1;
import theadEx.ThreadClassEx2;
import theadEx.ThreadClassEx4;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class main {

    public static void getResult(String name){
        System.out.println(name);
    }

    public static void main(String[] args) throws IOException {

        //Queue<Integer> queue = new LinkedList<>();

        QueueStackClass queueStackClass = new QueueStackClass();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println(queueStackClass.QueueSum(queue));
        System.out.println(queueStackClass.QueueSum(queue));




//        JsonClass jsonClass = new JsonClass();
//        jsonClass.basicJson();
//

        //Thread
//        ThreadClassEx1 thEx1 = new ThreadClassEx1();
//        thEx1.start();
//        System.out.println("------");

        //Thread2
//        String[] files = {"ex1.txt", "ex2.txt"};
//        for(String fileName : files){
//            ThreadClassEx2 thEx2 = new ThreadClassEx2(fileName);
//            thEx2.start();
//            System.out.println(thEx2.getResult());
//        }

//        String[] files = {"ex1.txt", "ex2.txt"};
//        for(String fileName : files){
//
//            ThreadClassEx4 thEx2 = new ThreadClassEx4(fileName);
//            thEx2.start();
//            while(true){
//                if(thEx2.getResult() != null){
//                    System.out.println(thEx2.getResult());
//                    break;
//                }
//            }
//
//        }





//        MathClass mc = new MathClass();
//        mc.setNumberDoubleDigit();
//
//
//
//        StringClass stc = new StringClass();
//        stc.getIndex();
//        stc.getLength();
//        stc.getSubString();




        //Encryption
//        System.out.println("-----------------------------------------");
//        String text = "Rosy Park";
//        Encryption encryption = new Encryption();
//
//        String encryptMD5 = encryption.MD5(text);
//        System.out.println("MD5 : " + encryptMD5);
//
//        String encryptSHA256 = encryption.SHA256(text);
//        System.out.println("SHA256 : " + encryptSHA256);
//
//        //FileIO
//        //1) 상대경로 주소
//        System.out.println("-----------------------------------------");
//        String path = FileIO.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져오기
//        System.out.println(path);

//        FileIO fo = new FileIO();
//        //fo.fileReadAndWrite();
//        fo.txtFileComparison(".\\src\\MONITORING.TXT", ".\\src\\nexText1");
//        fo.fileRead();
//        fo.fileWrite();
//        fo.fileReadAll();

//        //Random
//        RandomMaker rm = new RandomMaker();
//        rm.randomAlphabet();
//

//


    }



}
