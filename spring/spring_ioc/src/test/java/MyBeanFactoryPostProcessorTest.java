import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactoryPostProcessorTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myBeanFactoryPostProcessor.xml");
        Object bean = context.getBean("userDao");
        System.out.println(bean);
    }
}
