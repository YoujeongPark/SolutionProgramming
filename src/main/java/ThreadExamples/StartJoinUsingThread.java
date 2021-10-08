package ThreadExamples;
import java.util.concurrent.locks.ReentrantLock;

class ThreadClassLock extends Thread{
    static final ReentrantLock lock = new ReentrantLock(); // 가능하면 private final

    String threadName;

    public ThreadClassLock(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            printNumbers(threadName); //원하는 작업 실행
        }finally{
            lock.unlock();
        }
    }

    public static void printNumbers(String name){
        System.out.println(name);
        for(int i = 0 ; i <3; i++) {
            System.out.println(i);
        }
    }
}

public class StartJoinUsingThread {
    public static void main(String [] args) throws InterruptedException {
        Thread thread1 = new ThreadClassLock("thread1");
        Thread thread2 = new ThreadClassLock("thread2");

        thread1.start();
        thread2.start();

        ThreadClassLock.lock.lock(); //잠금
        try {
            ThreadClassLock.printNumbers("[Main]");
        }
        finally{
            ThreadClassLock.lock.unlock(); //잠금풀기
        }

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
