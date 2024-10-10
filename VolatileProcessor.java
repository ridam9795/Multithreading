package multithreading;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


class VolatileProcessor implements Runnable {
    private AtomicInteger count = new AtomicInteger();
    private int cnt2=0;
    public volatile String s="";
    public  int getCount2(){
        return cnt2;
    }
    public synchronized void increment(){
        cnt2+=2;
    }

    public String getStr(){
        return s;
    }

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
         while(sc.hasNext()){
             s=sc.nextLine();
             System.out.println(Thread.currentThread().getName());

         }
//        for (int i = 1; i < 10000; i++) {
//            processSomething(i);
//            count.incrementAndGet();
//            increment();
//            //System.out.println("count: "+this.count.get()+" thred "+Thread.currentThread().getName());
//        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}class VolatileProcessor2 extends VolatileProcessor  {



    @Override
    public void run() {
        int x=0;
        while(x<100){
            System.out.println(Thread.currentThread().getName());
            System.out.println(super.getStr());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x++;
        }


    }



}