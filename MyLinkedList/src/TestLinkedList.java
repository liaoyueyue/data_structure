import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-03
 * Time: 20:39
 */
public class TestLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        for (Integer i:
             linkedList) {
            System.out.print(i + "");
        }
        System.out.println("\n--------------");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + "");
        }
        System.out.println("\n--------------");
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "");
        }
        System.out.println("\n--------------");
        ListIterator<Integer> listIterator2 = linkedList.listIterator(linkedList.size());
        while (listIterator2.hasPrevious()) {
            System.out.print(listIterator2.previous() + "");
        }
    }
}
