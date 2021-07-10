package ThreadExamples;

class PriorityThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName());
        int i = 0;
        while(i<100){
            i+=1;
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + "-  priority" +  this.getPriority());
    }

}

public class PriorityThreadUsingThread {
    public static void main(String [] args){
        System.out.println("Main Thread Start");
        PriorityThread priorityThread10 = new PriorityThread();
        PriorityThread priorityThread5 = new PriorityThread();
        PriorityThread priorityThread1 = new PriorityThread();

        priorityThread1.setPriority(1);
        priorityThread5.setPriority(5);
        priorityThread10.setPriority(10);

        priorityThread1.start();
        priorityThread5.start();
        priorityThread10.start();

        System.out.println("Main Thread End");
    }

    /*
     * Main Thread Start
     * Thread-2
     * Main Thread End
     * Thread-1
     * Thread-0
     * Thread-1-  priority5
     * Thread-2-  priority1
     * Thread-0-  priority10
     */
}
