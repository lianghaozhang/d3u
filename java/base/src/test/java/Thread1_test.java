import ThreadDemo.Thread_1;

public class Thread1_test {
    public static void main(String[] args) {
//        创建自定义继承了Thread的类对象
        Thread_1 t1 = new Thread_1();
        Thread_1 t2 = new Thread_1();

//        为了方便观察并发给每个线程起个名字
        t1.setName("Thread1");
        t2.setName("Thread2");

//        开启线程
        t1.start();
        t2.start();
    }
}
