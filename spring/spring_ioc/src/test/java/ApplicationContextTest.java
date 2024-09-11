import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object userService = context.getBean("userDao");
//        System.out.println(userService);
        Object userDao99 = context.getBean("abc100");
        System.out.println(userDao99);
    }
}
