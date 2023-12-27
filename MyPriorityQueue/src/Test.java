import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-26
 * Time: 19:59
 */

class Student implements Comparable<Student>{
    public int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(5);
        priorityQueue.offer(3);
        PriorityQueue<Student> priorityQueue1 = new PriorityQueue<>(new AgeComparator());
        priorityQueue1.offer(new Student(2));
        priorityQueue1.offer(new Student(1));
        priorityQueue1.offer(new Student(1));
        priorityQueue1.offer(new Student(0));
        System.out.println();
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
