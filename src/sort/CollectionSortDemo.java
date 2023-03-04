package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortDemo {
    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>();
        list.add(5);
        list.add(50);
        list.add(7);
        list.add(14);
        list.add(1);
        list.add(2);

        for(Integer element: list) {
            System.out.println("Element of list before sorting: " + element);
        }

        Collections.sort(list);
        for(Integer element: list) {
            System.out.println("Element of list after sorting: " + element);
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"xiaofang", 90));
        studentList.add(new Student(2,"aiaofang", 90));
        studentList.add(new Student(3,"biaofang", 50));
        studentList.add(new Student(4,"aiaofang", 50));
        studentList.add(new Student(5,"xiaofang", 70));
        Collections.sort(studentList);
        for(Student s: studentList) {
            System.out.println("Student after sorting: " + s);
        }
    }
}
