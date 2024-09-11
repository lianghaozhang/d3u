package Beans;

import Annotation.MyComponent;
import Annotation.MyField;
import Annotation.MyTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MyComponent("student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MyTable("tb_student")
public class Student {
    @MyField(columnName = "sid", type = "int", length = 5)
    private int id;
    @MyField(columnName = "sname", type = "varchar", length = 10)
    private String name;
    @MyField(columnName = "sage", type = "int", length = 5)
    private int age;
}
