package oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-08
 * Time: 17:04
 */


public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    // 二叉搜索树与双向链表-https://www.nowcoder.com/share/jump/3054743731702912925445
    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 数据范围:输入二叉树的节点数0≤n≤1000，二树中每个节点的值0≤val≤1000
    // 要求:空间复杂度 O(1)(即在原树上操作)，时间复杂度 O(n)
    // 注意:
    // 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
    // 2.返回链表中的第一个节点的指针
    // 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
    private TreeNode prev = null;
    private void convertChild(TreeNode root) {
        if (root == null) return;
        convertChild(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        convertChild(root.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        convertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }


    // 二叉树的最近公共祖先
    // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode retLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode retRight = lowestCommonAncestor(root.right, p, q);
        if(retLeft != null && retRight != null) {
            return root;
        }else if(retLeft != null) {
            return retLeft;
        }else {
            return retRight;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root, p, stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root, q, stack2);
        int size1 = stack1.size();
        int size2 = stack2.size();
        if (size1 > size2) {
            int temp = size1 - size2;
            while (temp != 0) {
                stack1.pop();
                temp--;
            }
        } else {
            int temp = size2 - size1;
            while (temp != 0) {
                stack2.pop();
                temp--;
            }
        }
        // 两个栈， 元素个数一样
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() == stack2.peek()) {
                return stack1.peek();
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        return null; // 没有公共祖先
    }

    // 找到根节点到指定节点node之间路径上的所有节点，存储到stack当中
    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) {
            return false;
        }
        stack.push(root);
        if (root == node) {
            return true;
        }
        if (getPath(root.left, node, stack)) {
            return true;
        }
        if (getPath(root.right, node, stack)) {
            return true;
        }
        // 根节点不是， 根的左边和右边没有找到
        stack.pop();
        return false;
    }

    // 对称二叉树 | symmetric 对称的
    // 给你一个二叉树的根节点 root ， 检查它是否轴对称。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    private boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        // 一个为空，一个不为空
        if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return false;
        }
        // 两个都为空
        if (leftTree == null && rightTree == null) {
            return true;
        }
        // 判断值
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
    }

    // 平衡二叉树 时间复杂度：O(n^2)
    // 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = maxDepth(root.left);
        int rightTree = maxDepth(root.right);
        return leftTree > rightTree ? leftTree + 1 : rightTree + 1;
    }

    // 平衡二叉树 时间复杂度：O(n)
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxDepth2(root) >= 0;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = maxDepth(root.left);
        int rightTree = maxDepth(root.right);
        if (leftTree >= 0 && rightTree >= 0 && Math.abs(leftTree - rightTree) <= 1) {
            return Math.max(leftTree, rightTree) + 1;
        } else {
            return -1;
        }
    }

    // 另一棵树的子树
/*
    给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
    二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
*/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 相同的树
/*
    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        ret.addAll(preorderTraversal(root.left));
        ret.addAll(preorderTraversal(root.right));
        return ret;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));
        return ret;
    }

    // 后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.addAll(postorderTraversal(root.left));
        ret.addAll(postorderTraversal(root.right));
        ret.add(root.val);
        return ret;
    }
}
