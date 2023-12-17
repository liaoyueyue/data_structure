import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-08
 * Time: 16:37
 */
public class MyBinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.createTree();
        System.out.println("前序遍历");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\n中序遍历");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\n后续遍历");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.println("binaryTree.size(binaryTree.root) = " + binaryTree.size(binaryTree.root));
        binaryTree.size2(binaryTree.root);
        System.out.println("binaryTree.nodeSize = " + binaryTree.nodeSize);
        System.out.println("binaryTree.getLeafNodeCount(binaryTree.root) = " + binaryTree.getLeafNodeCount(binaryTree.root));
        System.out.println("binaryTree.getKLevelNodeCount(binaryTree.root, 2) = " + binaryTree.getKLevelNodeCount(binaryTree.root, 2));
        System.out.println("binaryTree.getHeight(binaryTree.root) = " + binaryTree.getHeight(binaryTree.root));
        System.out.println("binaryTree.find(binaryTree.root, 'G') = " + binaryTree.find(binaryTree.root, 'G').val);
        binaryTree.levelOrder(binaryTree.root);
        System.out.println("是不是完全二叉树： ");
        System.out.println(binaryTree.isCompleteTree(binaryTree.root));
    }

    public void createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        this.root = A;
    }

    // 前序遍历
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 获取树中节点的个数-子问题思路
    int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    // 获取树中节点的个数-遍历思路
    public static int nodeSize;

    void size2(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeSize++;
        size2(root.left);
        size2(root.right);
    }


    // 求叶子结点个数-子问题思路
    int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.left == null && root.right == null ? 1 : getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    // 求叶子结点个数-遍历思路
    public static int leafNodeSize;

    void getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodeSize++;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);
    }

    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    // 获取二叉树的高度
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftNode = find(root.left, val);
        if (leftNode != null) {
            return leftNode;
        }
        TreeNode rightNode = find(root.right, val);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    //层序遍历
    void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

    // 层序遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                size--;
                row.add((int) cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(row);
        }
        return ret;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return false;// 不是完全二叉树
            } else {
                queue.poll();
            }
        }
        return true;
    }
}
