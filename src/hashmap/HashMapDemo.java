package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        //如何构造HashMap
        Map<String, Double> map = new HashMap<>();

        // size/isEmpty
        System.out.println("Size of map: " + map.size());
        System.out.println("IsEmpty result: " + map.isEmpty());

        // put/putAll/putIfAbsent
        // 1.put ： 把键值对放入hash map （包含增和改）
        Double oldValue =  map.put("abc", 2.3);
        System.out.println("The value of abc: " + oldValue);// null -> add
        System.out.println("The current value of abc: " + map.get("abc"));
        oldValue = map.put("abcd", 2.56);
        System.out.println("The value of abcd: " + oldValue);// null -> add
        System.out.println("The current value of abc: " + map.get("abcd"));
        // 覆盖原来键值对，除非你明确地知道要去更新键值对的时候可以用重复的key调用put方法
        oldValue = map.put("abc", 2.5);
        System.out.println("2nd: The value of abc: " + oldValue);// 2.3 (old value) -> update
        System.out.println("The current value of abc: " + map.get("abc"));

        // 特例
        oldValue = map.put(null, null);// add
        System.out.println("The value of null: " + oldValue);

        oldValue = map.put(null, null);// update
        System.out.println("The value of null: " + oldValue);

        // 2. putIfAbsent: map.get(key) 为null，就把key-value放入map，否则返回key之前对应的value
        Double v = map.putIfAbsent("abc", 10.02); // 2.5
        System.out.println("v of abc: " + v);
        v = map.putIfAbsent("a", 111.11); //null
        System.out.println("v of a: " + v);
        System.out.println("The value of key a: " + map.get("a"));

        // 3.putAll 一般情况不建议使用
        System.out.println("The value of key d before putAll: " + map.get("d"));
        System.out.println("The value of key e before putAll: " + map.get("e"));
        Map<String, Double> newMap = new HashMap<>();
        newMap.put("d", 100.12);
        newMap.put("e", 100.13);
        newMap.put("a", 0.1);
        map.putAll(newMap);
        System.out.println("The value of key d: " + map.get("d"));
        System.out.println("The value of key e: " + map.get("e"));
        System.out.println("The value of key a: " + map.get("a"));

        // 1.get方法： （1）对于传入的key，存在value，返回这个value
        //（2）对于传入的key， 不存在对应的键值对，返回空
        Double valueOfABC = map.get("abc");
        System.out.println("The value of key abc: " + valueOfABC);

        Double valueOfJava = map.get("java");
        System.out.println("The value of key java: " + valueOfJava);

        // 特例
        map.put("nihao", null);
        System.out.println("The value of key nihao: " + map.get("nihao"));

        // 2.getOrDefault
        Double valueOfMethodGetOrDefault = map.getOrDefault("a", 10.05);
        System.out.println("The value of getOrDefault for key a: " + valueOfMethodGetOrDefault);// 0.1

        valueOfMethodGetOrDefault = map.getOrDefault("method", 0.33333);
        System.out.println("The value of getOrDefault for key method: " + valueOfMethodGetOrDefault);// 0.33333

        valueOfMethodGetOrDefault = map.getOrDefault("nihao", 0.33333);
        System.out.println("The value of getOrDefault for key nihao: " + valueOfMethodGetOrDefault);// null

        // containsKey/ containsValue
        System.out.println("The result of a: " + map.containsKey("a"));// true
        System.out.println("The result of method: " + map.containsKey("method"));// false

        System.out.println("The result of value 0.111111: " + map.containsValue(0.111111));// false
        System.out.println("The result of value 2.5: " + map.containsValue(2.5));// true

        // remove
        Double valueToRemove = map.remove("a"); // 0.1
        System.out.println("value to remove for key a: " + valueToRemove);

        valueToRemove = map.remove("method"); // null
        System.out.println("value to remove for key method: " + valueToRemove);

        // "abc" -> 2.5
        boolean isSuccess = map.remove("abc", 100.01);
        System.out.println("Flag isSuccess: " + isSuccess);
    }
}
