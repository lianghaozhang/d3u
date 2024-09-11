import ThreadDemo.Thread_2;

public class Thread2_test {
    public static void main(String[] args) {
        Thread_2 renwu = new Thread_2();

        Thread t1 = new Thread(renwu);
        Thread t2 = new Thread(renwu);
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("ni hao");
            }
        });

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
        t3.start();
    }
}
