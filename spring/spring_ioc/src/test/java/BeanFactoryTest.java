import com.lianghaozhang.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        //spring中默认的bean工厂实现
        DefaultListableBeanFactory beans = new DefaultListableBeanFactory(); //教室
        //创建读取器用来读取xml配置文件给bean工厂
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beans); // 参数：注册学生的名单用于哪个教室
        //读取配置文件给工厂
        reader.loadBeanDefinitions("beans.xml"); // 注册学生的名单，给教室
        //根据id获取bean对象实例
        UserService userService = (UserService) beans.getBean("userService");
//        System.out.println(userService);

        //依赖注入：上面的userService要用到dao，可以在配置文件中进行配置

    }
}
