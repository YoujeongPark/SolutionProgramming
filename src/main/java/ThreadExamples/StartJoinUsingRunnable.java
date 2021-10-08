package ThreadExamples;
import java.util.concurrent.locks.ReentrantLock;

class ThreadClassUsingRunnable implements Runnable{
    static final ReentrantLock lock = new ReentrantLock(); // 가능하면 private final

    String threadName;

    public ThreadClassUsingRunnable(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(threadName);
            printNumbers();
        }finally{
            lock.unlock();
        }

    }

    public static void printNumbers(){
        for(int i = 0 ; i < 3; i++) {
            System.out.println(i);
        }
    }
}


public class StartJoinUsingRunnable {
    public static void main(String [] args){
        Thread thread1 = new Thread(new ThreadClassUsingRunnable("thread1"));
        Thread thread2 = new Thread(new ThreadClassUsingRunnable("thread2"));

        thread1.start();
        thread2.start();

        ThreadClassUsingRunnable.lock.lock(); //잠금
        try {
            ThreadClassUsingRunnable.printNumbers();
        }
        finally{
            ThreadClassUsingRunnable.lock.unlock(); //잠금풀기
        }

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Main Thread를 먼저 진행한 후 각각 thread가 끝날때까지 기다려줌
                0
                1
                2
                thread1
                0
                1
                2
                thread2
                0
                1
                2

        */
    }
}
