import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import Annotation.MyField;
import Annotation.MyTable;

public class Reflection_Annotation {
    public static void main(String[] args) {
        try {
//            通过反射获取类的对象
            Class<?> clazz = Class.forName("Beans.Student");
//            获取到这个类的所以注解
            Annotation[] annotations = clazz.getAnnotations();
            String tableName;
            String columnName;
            String type;
            int length;
            System.out.println("类上的注解");
//            对所有注解进行便利
            for (Annotation annotation : annotations) {
//                当识别到MyTable注解时进行强转，然后获取传入注解的值
                if(annotation instanceof MyTable) {
                    MyTable myTable = (MyTable) annotation;
//                    获取注解的value
                    tableName = myTable.value();
                    System.out.println(tableName);
                }
            }
            System.out.println("------------");

            System.out.println("属性上的注解");
//            拿到所有的属性并遍历，再对每个属性进行注解扫描
            for (Field field : clazz.getDeclaredFields()) {
                for (Annotation annotation : field.getAnnotations()) {
//                    扫描到MyField注解时进行强转，并获取数据
                    if (annotation instanceof MyField) {
                        MyField myField = (MyField) annotation;
//                        获取数据
                        columnName = myField.columnName();
                        type = myField.type();
                        length = myField.length();
                        System.out.println(columnName + "-" + type + "-" + length);
                    }
                }
            }
            System.out.println("------------");

        } catch (Exception e) {

        }
    }
}
