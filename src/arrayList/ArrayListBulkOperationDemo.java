package arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListBulkOperationDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");

        List<String> stringList1 = new ArrayList<>();
        stringList1.add("A");
        stringList1.add("a");

        //containsAll - 在AbstractCollection实现，并不是在ArrayList里面实现
        //ArrayList里面能调用的原因，ArrayList继承了AbstractList，AbstractList继承了AbstractCollection，子类的对象可以调用父类暴露出来的方法
        boolean containsAllResult = stringList.containsAll(stringList1);
        System.out.println("Result of method containsAll: " + containsAllResult);

        // addAll/removeAll/retainAll - 在ArrayList里面实现
        // 加到ArrayList最后
        stringList.addAll(stringList1);
        for(String str: stringList) {
            System.out.println("String Element: " + str);
        }

        // 加到index位置，后面的元素往后移
        stringList.addAll(1, stringList1);
        for(int i=0;i<stringList.size();i++) {
            System.out.println(stringList.get(i));
        }

        //removeAll
        Collection<String> stringList2 = new ArrayList<>();
        stringList2.add("a");
        stringList2.add("Y");

        boolean removeAllResult = stringList.removeAll(stringList2);
        System.out.println(removeAllResult);
        for(int i=0;i<stringList.size();i++) {
            System.out.println("removeAll index: " + i +  "String: " + stringList.get(i));
        }

        //retainAll - 类似于交集操作，返回相同的部分
        Collection<String> stringList3 = new ArrayList<>();
        stringList3.add("b");
        stringList3.add("A");
        stringList.retainAll(stringList3);
        for(int i=0;i<stringList.size();i++) {
            System.out.println("retainAll index: " + i +  "String: " + stringList.get(i));
        }
    }
}
