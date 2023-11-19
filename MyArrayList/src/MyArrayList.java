import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 模拟顺序表
 * User: liaoyueyue
 * Date: 2023-11-19
 * Time: 16:50
 */
public class MyArrayList {
    public int[] elems;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 2; // capacity 容量

    public MyArrayList() {
        elems = new int[DEFAULT_CAPACITY];
    }

    // 打印顺序表
    public void display() {
        if (usedSize == 0) {
            System.out.println("没有元素");
        }
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elems[i] + " ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            elems = Arrays.copyOf(elems, 2 * elems.length);
        }
        elems[usedSize++] = data;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        checkAddPosIndexLegal(pos);
        if (isFull()) {
            elems = Arrays.copyOf(elems, 2 * elems.length);
        }
        for (int i = usedSize; i > pos; i--) {
            elems[i] = elems[i - 1];
        }
        elems[pos] = data;
        usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elems[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elems[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        checkGetSetPosIndexLegal(pos);
        return elems[pos];
    }

    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        checkGetSetPosIndexLegal(pos);
        elems[pos] = value;
    }

    // 删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            System.out.println("没有需要删除的值");
        } else {
            for (int i = index; i < usedSize - 1; i++) {
                elems[i] = elems[i + 1];
            }
            usedSize--;
        }
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        usedSize = 0;
    }

    /**
     * 判断顺序表是否满了
     *
     * @return 顺序表是否满了
     */
    private boolean isFull() {
        return usedSize == elems.length;
    }

    /**
     * 检查使用 Add 方法时传过来的 pos 下标是否合法
     *
     * @param pos 顺序表下标
     */
    private void checkAddPosIndexLegal(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new PosIndexNotLegalException("下标不合法");
        }
    }

    /**
     * 检查使用 Get、Set 方法时传过来的 pos 下标是否合法
     *
     * @param pos 顺序表下标
     */
    private void checkGetSetPosIndexLegal(int pos) {
        if (pos < 0 || pos >= usedSize) {
            throw new PosIndexNotLegalException("下标不合法");
        }
    }
}
