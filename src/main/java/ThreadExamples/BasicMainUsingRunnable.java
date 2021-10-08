package ThreadExamples;

class RunnableClass implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BasicMainUsingRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new RunnableClass();
        runnable.run();
    }

}
