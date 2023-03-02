package arrayList;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo<T> {
//    T[] items = new T[100];//无法创建泛型数组
//    T t = new T(); //无法创建泛型对象
    public void doSomething(Object element) {
        //无法对泛型进行实力判断
//        if (element instanceof T) {
//            System.out.println("element is T instance");
//        }
    }
    public static void main(String[] args) {
        List list = new ArrayList();
//        MyGenericArrayListV2<String> myGenericArrayListV2 = new MyGenericArrayListV2<>();
        //对于Java来说，List<String>中的String并不是真实存在的
        List<String> stringList = new ArrayList<>(); // list stringList

        //类型擦除 Type erasure -> 改变javac编译器，不需要改字节码，也不需要改虚拟机



    }
}
