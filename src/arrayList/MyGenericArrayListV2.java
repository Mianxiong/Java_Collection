package arrayList;

public class MyGenericArrayListV2<T> {
    private final static int DEFAULT_CAPACITY = 10;
    // 属性 field
    /**
     * The data storage of array list.
     */
    private T[] elementData;

    /**
     * The size of array list.
     */
    private int size;
    /**
     * The capacity of array list.
     */
    private int capacity;

    //构造器 constructor
    public MyGenericArrayListV2() {
//        this.elementData = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public MyGenericArrayListV2(int capacity) {
        if(capacity < 0) {
            throw new RuntimeException("Capacity must be positive");
        } else if(capacity < DEFAULT_CAPACITY) {
//            this.elementData = new Object[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
            this.size = 0;
        } else {
//            this.elementData = new Object[capacity];
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
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
    public int indexOf(T element) {
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
    public void add(T element) {
        add(size,element);
    }
    public void add(int index, T element) {
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
        elementData = (T[])newElementData;

        // 4.update capacity
        this.capacity = newCapacity;
    }

    /**
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        //0. index range check
        rangeCheck(index);
        //1. Get old value by index.
        T oldValue = elementData[index];

        //2. copy and shift
        int numToMoved = size - index - 1;
        if(numToMoved > 0) {
            System.arraycopy(elementData,index + 1, elementData, index, numToMoved);

        }
        //3. update size and clear
        elementData[--size] = null;
        return oldValue;
    }

    public boolean removeByValue(T element) {
        //遍历找到element，然后再删除移动
        for (int i=0; i<size; i++) {
            if (elementData[i].equals(element)) {
                int numToMoved = size - i - 1;
                if(numToMoved > 0) {
                    System.arraycopy(elementData,i + 1, elementData, i, numToMoved);
                }
                elementData[--size] = null;
                return true;
            }
        }
        return false;
    }
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size)  {
            throw new RuntimeException(
                    String.format("Index is invalid, index: [%d]", index));
        }
    }

    public Object set(int index,T element) {
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }


    public static void main(String[] args) {
        MyGenericArrayListV2<String> stringList = new MyGenericArrayListV2<>();
        stringList.add("abc");
//        stringList.add(1);
        MyGenericArrayListV2<Customer> customerList = new MyGenericArrayListV2<>();
        customerList.add(new Customer());
//        customerList.add(123);
    }
}
class Customer{
    String customerId;
    String name;
}