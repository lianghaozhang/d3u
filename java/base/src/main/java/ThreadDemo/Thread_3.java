package ThreadDemo;

import java.util.concurrent.Callable;

public class Thread_3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }
        return result;
    }
}
