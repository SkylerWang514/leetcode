package thread;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-03-09 17:57
 **/

public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args){

        Thread thread1 = new Thread(() -> {
            threadLocal.set(0);
            int value = threadLocal.get();
            System.out.println("thread 1:" + value);
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(1);
           int value = threadLocal.get();
            System.out.println("thread 2:" + value);
        });

        thread1.start();
        thread2.start();
    }
}
