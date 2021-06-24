package theadEx;

public class ThreadClassEx1 extends Thread{

    public ThreadClassEx1() {

    }

    public void run(){
        for(int i=0 ; i<=10 ; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
