package multithreading;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Main is starting");
//            Thread1 t1=new Thread1("thread1");
//            t1.start();
//
//            Thread t2=new Thread(new Thread2(),"thread2");
//            t2.start();
//
//            Thread t3=new Thread(()->{
//                for (int i=0;i<5;i++){
//                    System.out.println("inside "+Thread.currentThread()+" "+i);
//                }
//            },"thread3");
//            t3.start();
//        System.out.println("Main is exiting");

        Stack st=new Stack(5);
        Thread th1=new Thread(()->{
            int cnt=0;
            while(cnt<50){
              //  Stack.increment();
                st.push(100);
                cnt++;
            }
        });
        Thread th2=new Thread(()->{
            int cnt=0;
            while(cnt<50){
                //Stack.decrement();
                st.pop();
                cnt++;
            }
        });
        th1.start();
        th2.start();

//        BlockingQueue bq=new BlockingQueue(6);
//        Thread tb1=new Thread(()->{
//            int cnt=0;
//            while(cnt<10){
//                bq.add(cnt++);
//
//            }
//        });
//        Thread tb2=new Thread(()->{
//            int cnt=0;
//            while(cnt<10){
//                bq.remove();
//                cnt++;
//            }
//        });
//        tb1.start();
//        tb2.start();
        System.out.println("Main started");
        //Deadlock - A deadlock is as situation where a thread is waiting for an object lock that another thread
        //holds and this second thread is waiting for the object lock which first thread holds.
//        String lock1="ridam";
//        String lock2="nagar";
//        Thread tl1=new Thread(()->{
//            synchronized(lock1){
//                try {
//                    System.out.println("Thread 1");
//
//                    Thread.sleep(1000);
//                    synchronized (lock2){
//                        System.out.println("Lock acquired");
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        },"Thread1");
//        Thread tl2=new Thread(()->{
//            synchronized(lock2){
//                try {
//                    System.out.println("Thread 2");
//                    Thread.sleep(1000);
//                    synchronized (lock1){
//                        System.out.println("Lock acquired");
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        },"Thread2");
//        tl1.start();
//        tl2.start();



    }
}
