/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-03-18 14:31
 **/

public class Singleton {
    public static void main(String[] args) {
        // 创建10个线程数组
        Thread[] threads = new Thread[10];

        // 创建并启动10个线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread("Thread " + (i + 1));
            threads[i].start();
        }

        // 等待所有线程执行完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 所有线程执行完成后，执行主线程的逻辑
        System.out.println("All threads have finished executing. Main thread is now running.");
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running.");
            // 线程执行的逻辑
        }
    }
}
