import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-04
 * Time: 20:44
 */
public class MyStack {
    int[] elem;
    int useSize;

    public MyStack() {
        elem = new int[10];
        useSize = 0;
    }

    /**
     * 向栈添加元素
     * @param e 元素
     * @return 向栈添加的元素
     */
    public int push(int e) {
        ensureCapacity();
        elem[useSize++] = e;
        return e;
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public int peek() {
        if (empty()) {
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return elem[useSize - 1];
    }

    /**
     * 查看并删除栈顶元素
     * @return 栈顶元素
     */
    public int pop() {
        int e = peek();
        useSize--;
        return e;
    }

    public int getUseSize() {
        return useSize;
    }

    /**
     * 判断栈是否为空
     * @return 是否为空
     */
    private boolean empty(){
        return useSize == 0;
    }

    /**
     * 保证容量
     * ensure 确保
     * capacity 容量
     */
    private void ensureCapacity() {
        if (useSize == elem.length) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
    }
}
