package arrayList;

import java.util.AbstractList;
import java.util.List;

/**
 * The generic array list
 */
@SuppressWarnings("unchecked")
public class MyArrayList<E> extends AbstractList<E> implements List<E> {
    private final static int DEFAULT_CAPACITY = 10;
    // 属性 field
    /**
     * The data storage of array list.
     */
    private Object[] elementData;

    /**
     * The size of array list.
     */
    private int size;
    /**
     * The capacity of array list.
     */
    private int capacity;

    //构造器 constructor
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public MyArrayList(int capacity) {
        if(capacity < 0) {
            throw new RuntimeException("Capacity must be positive");
        } else if(capacity < DEFAULT_CAPACITY) {
            this.elementData = new Object[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
            this.size = 0;
        } else {
            this.elementData = new Object[capacity];
            this.capacity = capacity;
            this.size = 0;
        }
    }
    //method

    /**
     * get size of array list
     * @return the size of array list
     */
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }
    public int indexOf(Object element) {
        for(int i=0;i< elementData.length;i++) {
            if(elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    /**
     *
     * @param element
     */
    public boolean add(E element) {
        add(size(),element);
        return true;
    }
    public void add(int index, E element) {
        System.out.println("index: " + index);
        if (index < 0 || index > size) {
            throw new RuntimeException(
                String.format("Index is invalid, index: [%d]",index));
        }
        //判断capacity, size
        if (size == capacity) {
            //动态扩容： new_capacity = old_capacity * 2
            resize(size * 2);
        }
        for(int i=size; i> index; i--) {
            elementData[i] = elementData[i-1]; // elementData[1] = elementData[0]
        }
        elementData[index] = element;
        size++;
    }

    private void resize(int newCapacity) {
        // 1.Create new array
        Object[] newElementData = new Object[newCapacity];

        // 2.Copy data from element data array to new element data array
//        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        for(int i=0; i<elementData.length; i++) {
            newElementData[i] = elementData[i];
        }

        // 3.elementData point to new array
        elementData = newElementData;

        // 4.update capacity
        this.capacity = newCapacity;
    }

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        //0. index range check
        rangeCheck(index);
        //1. Get old value by index.
        E oldValue = (E) elementData[index];

        //2. copy and shift
        int numToMoved = size - index - 1;
        if(numToMoved > 0) {
            System.arraycopy(elementData,index + 1, elementData, index, numToMoved);

        }
        //3. update size and clear
        elementData[--size] = 0;
        return oldValue;
    }

    public boolean remove(Object element) {
        //遍历找到element，然后再删除移动
        for (int i=0; i<size; i++) {
            if (elementData[i].equals(element) ) {
                int numToMoved = size - i - 1;
                if(numToMoved > 0) {
                    System.arraycopy(elementData,i + 1, elementData, i, numToMoved);
                }
                elementData[--size] = 0;
                return true;
            }
        }
        return false;
    }
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size)  {
            throw new RuntimeException(
                    String.format("Index is invalid, index: [%d]", index));
        }
    }

    public E set(int index,E element) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }


    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        System.out.println("The size of list1: " + list1.size());
        System.out.println("empty of list 1: " + list1.isEmpty());
//        list1.add(20,10);
        for(int i=10; i<30; i++) {
            list1.add(i);
        }
        list1.add(1,100);

        System.out.println("The size of list 1: " + list1.size());
        System.out.println("contains 100: " + list1.contains(100));
        System.out.println("Number to remove: " + list1.remove(1));
        list1.remove(12);

        System.out.println("The size of list 1: " + list1.size());


        System.out.println("Element of index 5: " + list1.get(5));
        int oldValue = list1.set(5,150);
        System.out.println("Old value of index 5: " + oldValue);
        System.out.println("Current value of index 5: " + list1.get(5));


        MyArrayList<String> list2 = new MyArrayList<>(20);
//        list2.add(3);
        list2.add("abc");
        list2.add("hello world");
        System.out.println("size of list 2: "+ list2.size());
        System.out.println("Element of index 1: " + list2.get(1));
    }


}
