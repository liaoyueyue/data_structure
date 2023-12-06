package oj; /**
 * Created with IntelliJ IDEA.
 * Description: 用队列实现栈
 * User: liaoyueyue
 * Date: 2023-12-06
 * Time: 22:25
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 oj.MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public int usedSize;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        usedSize++;
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        if (!queue1.isEmpty()) {
            int curSize = queue1.size();
            for (int i = 0; i < curSize - 1; i++) {
                queue2.offer(queue1.poll());
            }
            usedSize--;
            return queue1.poll();
        } else {
            int curSize = queue2.size();
            for (int i = 0; i < curSize - 1; i++) {
                queue1.offer(queue2.poll());
            }
            usedSize--;
            return queue2.poll();
        }
    }

    public int top() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        if (!queue1.isEmpty()) {
            int curSize = queue1.size();
            int ret = -1;
            for (int i = 0; i < curSize; i++) {
                ret = queue1.poll();
                queue2.offer(ret);
            }
            return ret;
        } else {
            int curSize = queue2.size();
            int ret = -1;
            for (int i = 0; i < curSize; i++) {
                ret = queue2.poll();
                queue1.offer(ret);
            }
            return ret;
        }
    }

    public boolean empty() {
        return usedSize == 0;
    }
}
