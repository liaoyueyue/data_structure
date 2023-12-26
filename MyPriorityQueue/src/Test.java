import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-26
 * Time: 19:59
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    }
    public static void main2(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.initArray(array);
        testHeap.createHeap();
        testHeap.offer(80);
        System.out.println("test-stop");
    }
}
