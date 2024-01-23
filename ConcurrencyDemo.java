package Java_Internship;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new WorkerThread());
        Thread thread2 = new Thread(new WorkerThread());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }

    static class WorkerThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        }

        private void incrementCounter() {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }
    }
}


