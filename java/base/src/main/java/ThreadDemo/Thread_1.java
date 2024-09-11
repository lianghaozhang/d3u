package ThreadDemo;

public class Thread_1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + ": Hello World -> " + i);
        }
    }
}
