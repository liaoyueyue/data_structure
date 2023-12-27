import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-24
 * Time: 0:35
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public void initArray(int[] array) {
        elem = Arrays.copyOf(array, array.length);
        usedSize = elem.length;
    }

    /**
     * 创建大根堆-时间复杂度 O(n)
     * 最后一棵子树的最后一个节点 len - 1
     * 知道孩子节点 i 确定父亲节点 (i - 1) / 2
     * 最后一棵子树的根节点 (len - 1 - 1) / 2
     * 下一棵子树的根节点： 当前 根节点 - 1
     */
    public void createHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 实现 向下调整
     *
     * @param parent 每棵子树根节点的下标
     * @param len    每棵子树结束位置
     */
    private void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        // 保证有左孩子
        while (child < len) {
            // 判断左孩子和右孩子谁最打， 前提是有右孩子
            if (child + 1 < len  && elem[child] < elem[child + 1]) {
                child++;// 保存了最大值的下标
            }
            if (elem[child] > elem[parent]) {
                swap(elem, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void offer(int x) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[usedSize] = x;
        usedSize++;
        shiftUp(usedSize - 1);
    }

    // 入队
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                swap(elem, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    // 出队
    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int old = elem[0];
        swap(elem, 0, usedSize - 1);
        usedSize--;
        shiftDown(0, usedSize);
        return old;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public void heapSort() {
        int end = usedSize - 1;
        while (end > 0) {
            swap(elem, 0, end);
            shiftDown(0, end);
            end--;
        }
    }
}
