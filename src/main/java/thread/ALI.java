package thread;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: leetcode
 * @description: 多线程
 * @author: Skyler
 * @create: 2024-03-10 18:52
 **/

public class ALI {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Thread(new Printer(0, "a", atomicInteger)).start();
        new Thread(new Printer(1, "l", atomicInteger)).start();
        new Thread(new Printer(2, "i", atomicInteger)).start();
    }

    public static class Printer implements Runnable{
        int flag;
        String s;
        final AtomicInteger atomicInteger;
        public Printer(int flag, String s, AtomicInteger atomicInteger){
            this.flag = flag;
            this.s = s;
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while (true){
                synchronized (atomicInteger){
                    if (atomicInteger.get() % 3 == flag){
                        System.out.println(s);
                        if (atomicInteger.get() == 2) atomicInteger.set(0);
                        else atomicInteger.incrementAndGet();
                        atomicInteger.notifyAll();
                    }else {
                        try {
                            atomicInteger.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
