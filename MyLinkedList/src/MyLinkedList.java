/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-11-20
 * Time: 23:59
 */
public class MyLinkedList {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

    }
    private Node head; // 存储链表头节点的引用

    public void createList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.createList();
        list.display();
        list.addFirst(5);
        list.display();
        list.addLast(6);
        list.display();
        list.addIndex(6, 7);
        list.addIndex(7, 8);
        list.display();
        list.remove(7);
        list.display();
        list.addIndex(7, 9);
        list.display();
        list.addIndex(7, 9);
        list.display();
        list.removeAllKey(9);
        list.display();
        list.clear();
        list.display();
    }


    //头插法
    public void addFirst(int data){
        if (head == null) {
            head = new Node(data);
        } else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data);
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexNotlegalException("下标不合法");
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        checkAddIndex(index);
        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            Node node = new Node(data);
            Node preNode = findIndexPreOfOne(index);
            node.next = preNode.next;
            preNode.next = node;
        }
    }

    private Node findIndexPreOfOne(int index) {
        Node node = head;
        while (index - 1 != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
            return;
        }
        if (head.val == key) {
            head = head.next;
            return;
        }
        Node cur = findPreOfKey(key);
        if (cur == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    /**
     * 找到关键字 key 的前驱
     * @param key
     * @return
     */
    private Node findPreOfKey(int key) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点 -- 遍历列表一遍
    public void removeAllKey(int kay) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.val == kay) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == kay) {
            head = head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
//        this.head = null;
        Node cur = head;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        head = null;
    }

}
