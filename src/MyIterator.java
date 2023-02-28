import java.util.Iterator;

/**
 * 实现一个Iterator
 */
public class MyIterator implements Iterator {
    private final int[] nums;
    private int cursor;

    public MyIterator(int[] nums) {
        this.nums = nums;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
//        System.out.println(this.cursor);
//        System.out.println("length: " + nums.length);
//        return this.cursor <= this.nums.length;
        return this.cursor != this.nums.length;
    }

    @Override
    public Object next() {
        int number = nums[cursor];
//        System.out.println("number: " + number);
        cursor++;
        return number;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,6,7,9};
        Iterator iterator = new MyIterator(nums);
        while (iterator.hasNext()){
            int num = (int) iterator.next();
            System.out.println("The number for iterator: " + num);
        }

        int[] nums2 = new int[]{1,23,43,4332,323242};
        Iterator iterator1 = new MyIterator(nums2);
        while (iterator1.hasNext()) {
            System.out.println("The next number: " + iterator1.next());
        }

    }
}
