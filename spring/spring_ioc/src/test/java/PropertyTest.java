package java;

import com.lianghaozhang.dao.UserDao;
import com.lianghaozhang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyTest {
    public static void main(String[] args) {
//        System.setProperty("spring.profiles.active", "dev");
//        ApplicationContext context = new ClassPathXmlApplicationContext("profileDemo.xml");
//        Abc abc1 = (Abc) context.getBean("abc1");
//        Abc abc2 = (Abc) context.getBean("abc2");
//        System.out.println(abc1);
//        System.out.println(abc2);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService1 = (UserService) context.getBean("userService");
        UserService userService2 = context.getBean(UserService.class);
        UserDao userDao1 = context.getBean("userDao1", UserDao.class);
        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userDao1);
    }
}
