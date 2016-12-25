package net.xuele.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yejunjie on 2016/12/17.
 */
public class ComparatorTest {


    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId("1");

        Student s2 = new Student();
        s2.setId("2");

        Student s3 = new Student();
        s3.setId("3");

        List<Student> list = new ArrayList<Student>();
        list.add(s2);
        list.add(s1);
        list.add(s3);

        //sort 升序排列   reverse 降序排列    修改 o1和o2的位置 可以翻转排序方式
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //compareTo  o1>o2 返回正数  比较通过char比较  so 3100 < 390
                return  o1.getId().compareTo(o2.getId());
            }
        });

        System.out.print(list.toString());

        System.out.print("aaaa111 iss53 合并");
    }

}
