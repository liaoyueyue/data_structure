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
}
