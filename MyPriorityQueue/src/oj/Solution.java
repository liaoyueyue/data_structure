package oj;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-27
 * Time: 0:25
 */
public class Solution {
    // 最小K个数
    // 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
    //    提示：
    //            0 <= len(arr) <= 100000
    //            0 <= k <= min(100000, len(arr))
    public int[] smallestK1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        for (int elem : arr) {
            priorityQueue.offer(elem);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    public int[] smallestK2(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
