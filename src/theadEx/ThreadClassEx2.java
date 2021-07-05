package theadEx;

public class ThreadClassEx2 extends Thread{

    public ThreadClassEx2() {

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
