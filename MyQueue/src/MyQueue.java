import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-06
 * Time: 0:32
 */
public class MyQueue {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node head; // 队列的头
    public Node tail; // 队列的尾

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    /**
     * 入队操作
     * @param val 节点的值
     */
    public void offer(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    /**
     * 出队操作
     * @return 出队的节点的值
     */
    public int pop() {
        // 没有节点
        if (head == null) {
            throw new RuntimeException("队列内没有节点");
        }
        int oldVal = head.val;
        // 只有一个节点
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return oldVal;
    }

    /**
     * 查看队头节点的值
     * @return 队头节点的值
     */
    public int peek() {
        if (head == null) {
            throw new RuntimeException("队列内没有节点");
        }
        return head.val;
    }





}
