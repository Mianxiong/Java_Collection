package arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        List<Integer> integerList2 = new ArrayList<>(c);
        System.out.println("integerList2" + integerList2);

        //等价
        List<Integer> integerList3 = new ArrayList<>();
        for (Integer integer: c) {
            integerList3.add(integer);
        }
        System.out.println("integerList3" + integerList2);


    }
}
