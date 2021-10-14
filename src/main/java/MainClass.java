import main.java.MathClass;
import main.java.QueueStackClass;
import main.java.SortingClass;
import main.java.StringClass;
import org.w3c.dom.ls.LSOutput;
import theadEx.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

class ThreadClass extends Thread{
    String threadName;
    public ThreadClass(String name){
        this.threadName = name;
    }

    public void run(){
        for(int i = 1; i<=10 ; i++){
            System.out.println(threadName + " " + i );
            try{
                sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println();

    }
}



class Mutex extends Thread {
    static ReentrantLock lock = new ReentrantLock();

    String threadName;

    public Mutex(String name){
        this.threadName = name;
    }

    public void run(){
        lock.lock();
        try{
            printNums(threadName);
        }finally{
            lock.unlock();
        }
    }

    public static void printNums(String name){
        int i;
        System.out.println(name);
        for(i = 1; i<=10 ; i++){
            System.out.print(i + " ");
        }
        System.out.println();

    }

}


class main {

    public static void getResult(String name){
        System.out.println(name);
    }

    public static void main(String[] args) throws IOException, InterruptedException {


            JsonClass jsonClass = new JsonClass();
            jsonClass.makingJson();
            jsonClass.basicJson();
            jsonClass.readingJson();
            jsonClass.checkingTypeJson();



            /** 일반 쓰레드  **/
            ThreadClass thEx1 = new ThreadClass("thread1");
            ThreadClass thEx2 = new ThreadClass("thread2");
            thEx1.start();
            thEx2.start();

            for(int i = 1; i<=10 ; i++){
                System.out.println("main" + " "+ i);
                Thread.sleep(10);
            }

            thEx1.join();
            thEx2.join();


            /** mutex Example - Thread 2개 만든 후 Main, thread 동시 연속 **/
            Mutex mutex1 = new Mutex("mutex1");
            Mutex mutex2 = new Mutex("mutex2");
            mutex1.start();
            mutex2.start();

            Mutex.lock.lock();

            try{
                Mutex.printNums("Main");
            }finally{
                Mutex.lock.unlock();
            }
            mutex1.join();
            mutex2.join();





//            ThreadClassEx1 thEx1 = new ThreadClassEx1();
//            thEx1.start();
//            System.out.println("------");




//            SortingClass sortingClass = new SortingClass();
//            sortingClass.collectionsSorting();

//            MathClass mathClass = new MathClass();
//            System.out.println(mathClass.between(2,1,3));


        //Queue<Integer> queue = new LinkedList<>();

//        QueueStackClass queueStackClass = new QueueStackClass();
//
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.offer(1);
//        queue.offer(1);
//        queue.offer(1);
//        queue.offer(1);
//        queue.offer(1);
//
//        System.out.println(queueStackClass.isQueueAllSame(queue));






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
