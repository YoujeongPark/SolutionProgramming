package theadEx;
import java.util.concurrent.locks.ReentrantLock;

public class MutexClass extends Thread {
    ReentrantLock lock = new ReentrantLock();

    String threadName;

    public MutexClass(String name){
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

    public void printNums(String name){
        int i;
        System.out.println(name);
        for(i = 1; i<=10 ; i++){
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
