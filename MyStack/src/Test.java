import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-04
 * Time: 20:58
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "(()){}";
        String s2 = "(()){]}";
        System.out.println("isValid(s1) = " + isValid(s1));
        System.out.println("isValid(s2) = " + isValid(s2));

    }


    /*    有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。*/
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curch = s.charAt(i);
            if (curch == '(' || curch == '[' || curch == '{') {
                stack.push(curch);
            } else {
                // 右括号
                if (stack.empty()) {
                    // 右括号多
                    return false;
                }
                char stackTop = stack.peek();
                if (curch == ')' && stackTop == '(' || curch == ']' && stackTop == '[' || curch == '}' && stackTop == '{') {
                    stack.pop();
                } else {
                    // 左右括号不匹配
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            // 左括号多
            return false;
        }
    }

    /*    逆波兰表达式求值
        给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
        请你计算该表达式。返回一个表示表达式值的整数。
        注意：
        有效的算符为 '+'、'-'、'*' 和 '/' 。
        每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        两个整数之间的除法总是 向零截断 。
        表达式中不含除零运算。
        输入是一个根据逆波兰表示法表示的算术表达式。
        答案及所有中间计算结果可以用 32 位 整数表示。*/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String curS : tokens) {
            if (!isOperation(curS)) {
                stack.push(Integer.valueOf(curS));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (curS) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOperation(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    /*    栈的压入、弹出序列
        输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
                1. 0<=pushV.length == popV.length <=1000
                2. -1000<=pushV[i]<=1000
                3. pushV 的所有数字均不相同*/
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        if (pushV.length == 0 || popV.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]); // 将元素压入栈中
            while (j < popV.length && !stack.isEmpty() && stack.peek().equals(popV[j]) ) {
                // 如果栈顶元素和当前弹出序列元素相等，就弹出栈顶元素并移动弹出序列的指针
                stack.pop();
                j++;
            }
        }
        // 最后判断栈是否为空，为空说明弹出序列是可能的
        return stack.isEmpty();
    }
}
