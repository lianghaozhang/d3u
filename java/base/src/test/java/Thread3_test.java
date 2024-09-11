import ThreadDemo.Thread_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread3_test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建任务
        Thread_3 renwu = new Thread_3();
//        将任务的结果交给FutureTask管理
        FutureTask<Integer> ft = new FutureTask<>(renwu);
//        将FutureTask放到线程中执行，线程返回的结果存在ft中
        Thread t = new Thread(ft);
//        启动线程
        t.start();
//        获取线程返回的结果
        System.out.println(ft.get());
    }
}
