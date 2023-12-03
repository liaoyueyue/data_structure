import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-11-20
 * Time: 23:59
 */
public class MyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    private ListNode head; // 存储链表头节点的引用

    public void createList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
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
    public void addFirst(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode node = new ListNode(data);
            node.next = head;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(data);
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
            ListNode node = new ListNode(data);
            ListNode preNode = findIndexPreOfOne(index);
            node.next = preNode.next;
            preNode.next = node;
        }
    }

    private ListNode findIndexPreOfOne(int index) {
        ListNode node = head;
        while (index - 1 != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
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
        ListNode cur = findPreOfKey(key);
        if (cur == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    /**
     * 找到关键字 key 的前驱
     *
     * @param key
     * @return
     */
    private ListNode findPreOfKey(int key) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
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
        ListNode prev = head;
        ListNode cur = prev.next;
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
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
//        this.head = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        head = null;
    }

    // 反转链表
    public ListNode ReverseList() {
        if (head == null) { // 链表为空
            return null;
        }
        if (head.next == null) { // 链表只有一个节点
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode cutNext = cur.next;
            cur.next = head;
            head = cur;
            cur = cutNext;
        }
        return head;
    }

    // 给你单链表的头结点 head ，请你找出并返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode() {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode first = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
        }
        return slow;
    }

    // 输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head;
        ListNode slow = head;
        while (k - 1 != 0) {
            first = first.next;
            if (first == null) {
                return null;
            }
            k--;
        }
        while (first.next != null) {
            first = first.next;
            slow = slow.next;
        }
        return slow;
    }

    // 合并两个有序链表,将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(-1);
        ListNode cur = newList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return newList.next;
    }

    // 链表分割,现有一链表的头指针 ListNode* pHead，给一定值x，编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    public ListNode partition(ListNode pHead, int x) {
        ListNode bs = null, be = null; // 第一段
        ListNode as = null, ae = null; // 第二段
        ListNode cur = pHead;
        while (cur != null) {
            // 插入到第一段-尾插
            if (cur.val < x) {
                if (bs == null) {
                    // 第一次插入
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                // 插入到第二段-尾插
                if (as == null) {
                    // 第一次插入
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        if (as != null) {
            ae.next = null;
        }
        be.next = as;
        return bs;
    }

//    链表的回文结构
/*
    对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
*/
    public boolean chkPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找链表中间
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 开始翻转
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        // 开始判断回文
        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    // 相交链表
    // 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别求两个链表的长度
        int lenA = 0;
        int lenB = 0;
        ListNode pl = headA; // p1永远指向最长的链表
        ListNode ps = headB; // ps永远指向最短的链表
        while(pl != null){
            lenA++;
            pl = pl.next;
        }
        while(ps != null) {
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        // 2.pl长链表 ps短链表 len为0或者正数,让长链表走差值步
        while(len != 0) {
            pl = pl.next;
            len--;
        }
        // 3.长短链表一起走
        // while(pl != ps && pl != null){
        while(pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        // if(pl == null){
        //     return null;
        // }
        return pl;
    }

//    环形链表
/*    给你一个链表的头节点 head ，判断链表中是否有环。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
    如果链表中存在环 ，则返回 true 。 否则，返回 false 。*/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

//    环形链表 II
/*    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    不允许修改 链表。*/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow =  head;
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
