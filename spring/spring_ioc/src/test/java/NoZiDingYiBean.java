import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;

public class NoZiDingYiBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("noZiDingYiBean.xml");
//        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
//        System.out.println(dataSource);

        // 获取数据库连接
//        Object connection = context.getBean("connection");
//        System.out.println(connection);

//        Object date = context.getBean("date");
//        System.out.println(date);
        Object sqlSessionFactory = context.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory);
    }
}
