import java.util.Arrays;

/**
 * 动态数组
 *
 * @author lijialin
 * Created on 2022-04-18
 */
public class DynamicArray<T> {
    /**
     * 容量
     */
    private int capacity;
    /**
     * 数组中的元素个数
     */
    private int size;
    /**
     * 实际存储数据的数组
     */
    private Object[] data;

    private static final int MIN_CAPACITY = 10;

    public DynamicArray(int capacity) {
        this.capacity = Math.min(capacity, MIN_CAPACITY);
        this.size = 0;
        this.data = new Object[] {};
    }

    public DynamicArray() {
        this.capacity = MIN_CAPACITY;
        this.size = 0;
        this.data = new Object[] {};
    }

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        return (T) data[index];
    }

    public boolean add(T t) {
        // 放置元素后, size += 1, 此时size != this.size
        grow(size + 1);
        data[size++] = t;
        return true;
    }

    private void grow(int size) {
        if (size <= data.length) {
            return;
        }

        int calculatedCapacity;
        if (size < MIN_CAPACITY) {
            calculatedCapacity = MIN_CAPACITY;
        } else {
            calculatedCapacity = capacity + (capacity >> 1);
        }
        data = Arrays.copyOf(data, calculatedCapacity);
        this.capacity = data.length;
    }

    private String outOfBoundsMsg(int index) {
        return String.format("index: %d, size: %d", index, size);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
