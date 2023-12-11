package oj;

import java.util.ArrayList;
import java.util.List;

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

    //    另一棵树的子树
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
