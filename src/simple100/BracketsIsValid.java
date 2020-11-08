package simple100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author EricRaww
 * @create 2020-11-07
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * <p>
 * 解题思路 用栈
 */
public class BracketsIsValid {
    public static void main(String[] args) {
        String s = "{[()]}";
//        String s = "){";
//        System.out.println(isValid(s));
        System.out.println(isValidFromleetcode(s));
    }

    //not used
    public static boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.startsWith("{") || s.startsWith("[") || s.startsWith("(")) {
                if (s.charAt(i) == 123 && s.charAt(s.length() - i - 1) != 125 && s.charAt(i + 1) != 125) {
                    return false;
                } else if (s.charAt(i) == 91 && s.charAt(s.length() - i - 1) != 93 && s.charAt(i + 1) != 93) {
                    return false;
                } else if (s.charAt(i) == 40 && s.charAt(s.length() - i - 1) != 41 && s.charAt(i + 1) != 41) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidFromleetcode(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>(3);
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}