package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    Queue<Integer> queue;
    int capacity;

    BlockingQueue(int capacity){
        this.capacity=capacity;
        queue=new LinkedList<>();
    }
    public boolean add(int x){
        synchronized(queue){
            System.out.println("Add called "+queue);
            while(queue.size()==capacity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(x);
            queue.notifyAll();
            return true;
        }
    }
    public boolean remove(){
        synchronized (queue){
            System.out.println("Remove called "+queue);
            while(queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.poll();
            queue.notifyAll();
            return true;

        }
    }

}
