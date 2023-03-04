package sort;

import java.util.Arrays;

public class ArraySortDemo {
    public static void main(String[] args) {
        int[] nums = {100,3,4,5,2,2,1,3,7,9,9};

        for(int num: nums) {
            System.out.println("The number before sorting: " + num);
        }

        // 按从小到大排序 升序，原址排序（没有开辟新的数组）
        // ascending numerical order
        Arrays.sort(nums);

        for(int num: nums) {
            System.out.println("The number after sorting: " + num);
        }

        // 结论： 对基本类型数组都提供了两种sort方法
        // 1. 对整个数组排序
        // 2. 对数组中一段区间排序[fromIndex, toIndex]

        char[] chars = {'a', 'z', 'y', 'v', 'v', 'n', 'm', 'b', 'c', 'a'};

        // index [1,4]排序
        Arrays.sort(chars, 1, 5);
        for(char ch: chars) {
            System.out.println("The char after sorting: " + ch);
        }

        //Student
        Student[] students = new Student[5];
        students[0] = new Student(1,"xiaofang", 90);
        students[1] = new Student(1,"xiaofang", 80);
        students[2] = new Student(1,"xiaofang", 50);
        students[3] = new Student(1,"xiaofang", 60);
        students[4] = new Student(1,"xiaofang", 70);

        // 没有明确的比较规则

        // Student implements Comparable
        Arrays.sort(students);

        for (Student student: students) {
            System.out.println("Student: " + student.toString());
        }

        // String里面会自己实现Comparable接口
        String[] strings = {"abc", "zzz", "dbd", "qwer"};
        Arrays.sort(strings);
        for(String str: strings) {
            System.out.println("String after sorting: " + str);
        }
    }
}

//class Student {
//    private int id;
//    private String name;
//    private int score;
//
//    public Student(int id, String name, int score) {
//        this.id = id;
//        this.name = name;
//        this.score = score;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", score=" + score +
//                '}';
//    }
//}