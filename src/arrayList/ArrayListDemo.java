package arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ArrayListDemo {
    class User{
        int id;
        String name;
    }
    public static void main(String[] args) {
        //如何构造声明ArrayList
        // (1)不带类型的
        ArrayList list = new ArrayList();

        // (2)带类型的 <>里面全部要引用类型 （基本类型要转化成包装类）
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(100);
//        integerArrayList.add("zzz");//报错：Required type:Integer   Provided:String

        // (3)推荐写法
        List<Integer>  integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>(100);

        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(3);
        c.add(3);

        List<Integer> integerList2 = new ArrayList<>(c);
        System.out.println("integerList2" + integerList2);

        //等价
        List<Integer> integerList3 = new ArrayList<>();
        for (Integer integer: c) {
            integerList3.add(integer);
        }
        System.out.println("integerList3" + integerList2);

        //size/isEmpty/contains
        System.out.println("Size: " + integerList2.size());
        integerList2.add(100);
        System.out.println("Size: " + integerList2.size());
        System.out.println("Is Empty: " + integerList2.isEmpty());

        if(!integerList2.isEmpty()) {
            System.out.println("The list is not Empty");
        }
        System.out.println("contains abc: " + integerList2.contains("abc"));
        System.out.println("contains 100: " + integerList2.contains(100));

        System.out.println("1 indexOf: " + integerList2.indexOf(1));
        System.out.println("3 indexOf: " + integerList2.indexOf(3));
        System.out.println("100 indexOf: " + integerList2.indexOf(100));
        System.out.println("1000 indexOf: " + integerList2.indexOf(1000));
        System.out.println("3 lastIndexOf: " + integerList2.lastIndexOf(3));
        System.out.println("10000 lastIndexOf: " + integerList2.lastIndexOf(10000));

        //toArray方法
        Object[] arrays = integerList2.toArray();
        for(Object array: arrays) {
            int number = (int) array;
            System.out.println(number);
        }

        Integer[] ints = integerList2.toArray(new Integer[0]);
        for(int number: ints) {
            System.out.println("int number: "+ number);
        }
        System.out.println("length: " + ints.length);

        //get/add/remove/set

        //get - array[index]
        System.out.println("Element in index: 0 " + integerList2.get(0));

        for(Integer num: integerList2) {
            System.out.println("num: " + num);
        }
        for(int i=0; i<integerList2.size();i++) {
            System.out.println("num: " + integerList2.get(i));
        }
        //set(index,value) - array[index] = value
        integerList2.set(1,10);
        System.out.println("Element in index: 1 " + integerList2.get(1));

        integerList2.forEach(System.out::println);

        // add
        integerList2.add(5);//加到最后
        System.out.println("Element in index 6 : " + integerList2.get(6));
        System.out.println("Size: "+ integerList2.size());

        integerList2.add(2,10000);//加到index位置，其他后面的元素往右移
        System.out.println("Size: " + integerList2.size());

        for(int i=0;i<integerList2.size();i++) {
            System.out.println("Number: " + integerList2.get(i));
        }

        int toRemoved = integerList2.remove(2);
        System.out.println("toRemoved: " + toRemoved);
        boolean isSuccess = integerList2.remove(new Integer(3));
        System.out.println(isSuccess);
        for(int i=0;i<integerList2.size();i++) {
            System.out.println("Number: " + integerList2.get(i));
        }

        //clear
        System.out.println("Size: " + integerList2.size());
        integerList2.clear();
        System.out.println("Size: " + integerList2.size());



    }
}
