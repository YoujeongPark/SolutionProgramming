package ThreadExamples;

/* Reference
 *  https://www.bswen.com/2018/04/java-Two-ways-to-ensure-the-thread-execute-order.html
 * */

class ThreadSequence extends Thread{
    private final String name;

    public ThreadSequence(String name){
        super(name);
        this.name = name;
        this.setName(name);
    }

    @Override
    public void run(){
        try{
            System.out.println("현재 Thread" + this.getName());
            Thread.sleep(3000);
        }catch(InterruptedException e){

        }
    }
}


public class SequenceThreadUsingThread {
    public static void SequenceThreadUsingThread(String [] args) throws InterruptedException {
        Thread thread1 = new ThreadSequence("thread1");
        Thread thread2 = new ThreadSequence("thread2");
        Thread thread3 = new ThreadSequence("thread3");


        thread1.start();
        thread1.join(); // wait until thread1 is done
        thread2.start();
        thread2.join(1000); // wait at most 1 second
        thread3.start();



    }
}


