import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanDefinitionRegistryPostProcessor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myBeanDefinitionRegistryPostProcessor.xml");
        System.out.println(context.getBean("abc100"));
    }
}
