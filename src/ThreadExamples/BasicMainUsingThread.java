package ThreadExamples;

class ThreadClass extends Thread {

    @Override
    public void run() {
        printNumbers();
    }

    public static void printNumbers(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BasicMainUsingThread {
    public static void main(String [] args){
        Thread thread = new ThreadClass();
        thread.start();
    }
}
