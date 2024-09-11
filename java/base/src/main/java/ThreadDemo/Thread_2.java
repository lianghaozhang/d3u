package ThreadDemo;

public class Thread_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": Hello World -> " + i);
        }
    }
}
