package multithreading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stack {
    int arr[];
    int stackTop;
    final Object lock;
    private Lock l=new ReentrantLock();
    static int cnt=0;
    static int brr[]=new int[5];
    Stack(int capacity){
        arr=new int[capacity];
        stackTop=-1;
        lock=new Object();
    }
    boolean isFull(){
        return stackTop>=arr.length-1;
    }
    boolean isEmpty(){
        return stackTop < 0;
    }
//    public boolean push(int ele) {
//        synchronized (lock){
//            System.out.println("push: "+ele);
//            if(isFull()){
//                return false;
//            }
//            stackTop++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            arr[stackTop]=ele;
//            return true;
//        }
//
//    }
//    public int pop()  {
//        synchronized (lock){
//            System.out.println("pop called ");
//            if(isEmpty()){
//                return Integer.MIN_VALUE;
//            }
//            int obj=arr[stackTop];
//            arr[stackTop]=Integer.MIN_VALUE;
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            stackTop--;
//            return obj;
//        }
//
//
//    }
    public synchronized static void increment(){
        System.out.println("Increment "+cnt);


        brr[cnt]=cnt*2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cnt++;

    }
    public synchronized static void decrement(){
        System.out.println("Decrement "+cnt);

        brr[cnt]=cnt*2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cnt--;

    }
    public  boolean push(int ele) {
        l.lock();
        cnt++;
        System.out.println("push called "+cnt);
            if(isFull()){
                l.unlock();
                return false;
//                try {
//               //     this.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return false;
            }
            stackTop++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arr[stackTop]=ele;
        System.out.println(Arrays.toString(arr));
        //    this.notifyAll();
             l.unlock();
            return true;



    }
    public  int pop()  {
        l.lock();
        cnt++;
            System.out.println("pop called "+cnt);
            if(isEmpty()){
                l.unlock();
                return Integer.MIN_VALUE;
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                //return Integer.MIN_VALUE;
            }
            int obj=arr[stackTop];
            arr[stackTop]=Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stackTop--;
        System.out.println(Arrays.toString(arr));

       // this.notifyAll();
        l.unlock();
            return obj;
        }




}
