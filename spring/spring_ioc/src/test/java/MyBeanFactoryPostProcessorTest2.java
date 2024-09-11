import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactoryPostProcessorTest2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myBeanFactoryPostProcessor.xml");
        System.out.println(context.getBean("aaabbbccc"));
    }
}
