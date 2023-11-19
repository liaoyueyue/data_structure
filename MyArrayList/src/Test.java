/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-11-19
 * Time: 16:50
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.display();
        arrayList.add(1, 7);
        arrayList.display();
        arrayList.add(6, 8);
        arrayList.display();
        arrayList.add(0, 9);
        arrayList.display();
        System.out.println("查询是否包含88："+arrayList.contains(1));
        System.out.println("查询元素2的索引："+arrayList.indexOf(2));
        System.out.println("获取下标为7的元素："+arrayList.get(7));
        arrayList.set(7, 7);
        arrayList.display();
        arrayList.remove(9);
        arrayList.display();
        arrayList.remove(7);
        arrayList.display();
        System.out.println("arrayList.size() = " + arrayList.size());
        arrayList.clear();
        arrayList.display();
    }
}
