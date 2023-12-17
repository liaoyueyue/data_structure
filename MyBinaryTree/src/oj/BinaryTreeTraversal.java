package oj;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树遍历
 * User: liaoyueyue
 * Date: 2023-12-17
 * Time: 22:00
 */

/**
 * https://www.nowcoder.com/share/jump/3054743731702821717343" oj链接
 * 描述
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 * 输入描述：
 * 输入包括1行字符串，长度不超过100。
 * 输出描述：
 * 可能有多组测试数据，对于每组数据， 输出将输入字符串建立二叉树后中序遍历的序列，每个字符后面都有一个空格。 每个输出结果占一行。
 * 示例1
 * 输入：
 * abc##de#g##f###
 * 输出：
 * c b e g d f a
 */
public class BinaryTreeTraversal {
    class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public int i = 0;
    public TreeNode createTree(String s) {
        TreeNode root = null;
        if(s.charAt(i) != '#'){
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTree(s);
            root.right = createTree(s);
        }else{
            i++;
        }
        return root;
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            BinaryTreeTraversal m = new BinaryTreeTraversal();
            TreeNode root = m.createTree(s);
            m.inOrder(root);
        }
    }
}
