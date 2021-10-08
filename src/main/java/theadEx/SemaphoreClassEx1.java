package theadEx;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreClassEx1 {
    private static final Random random = new Random(10000);

    static class Log{
        public static void debug(String message){
            System.out.println(Thread.currentThread().getName() + " : " + message);
        }
    }

    public static class SemaphoreResource extends Semaphore {
        private static final long serialVersionUID = 1L;

        public SemaphoreResource(final int permits){
            super(permits);
        }

        public void use() throws InterruptedException{
            acquire();
            try {
                doUse();
            }finally{
                release();
                Log.debug("Thread 종료 후 남은 permits" + this.availablePermits());
            }
        }

        protected void doUse() throws InterruptedException{
            int sleepTime = random.nextInt(500);
            Thread.sleep(sleepTime);
            Log.debug("Thread 실행 ..." + sleepTime);

        }

    }

    class MyThread extends Thread{
        private final SemaphoreResource resource;

        public MyThread(String threadName, SemaphoreResource resource){
            this.resource = resource;
            this.setName(threadName);

        }

        @Override
        public void run(){
            try {
                resource.use();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
