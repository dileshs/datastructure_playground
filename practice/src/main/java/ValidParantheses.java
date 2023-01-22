package main.java;

import java.util.Stack;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.


        Example 1:

        Input: s = "()"
        Output: true
        Example 2:

        Input: s = "()[]{}"
        Output: true
        Example 3:

        Input: s = "(]"
        Output: false*/
public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("({[]}){}(("));
    }

    /*private static boolean isValid(String s) {
        if (s.length()%2 != 0) return false;
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put('}','{');
        closeToOpenMap.put(')','(');
        closeToOpenMap.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int pointer = -1;
        for (int i=0; i < chars.length; i++) {
            if (closeToOpenMap.containsKey(chars[i])) {
                if (stack.isEmpty() || stack.pop() != closeToOpenMap.get(chars[i]))
                    return false;
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }*/


    public static boolean isValid(String s) {
        if (s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.

        return stack.isEmpty();
    }

    // 2. without stack
    /*
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        int top = -1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (top < 0 || !isMatch(sb.charAt(top), sb.charAt(i))) {
                top++;
                sb.setCharAt(top, sb.charAt(i));
            } else {
                top--;
            }
        }
        return top == -1;
    }

    private boolean isMatch(char c1, char c2){
        if(c1 == '(' && c2 == ')') return true;
        if(c1 == '[' && c2 == ']') return true;
        if(c1 == '{' && c2 == '}') return true;
        return false;
    }
    */
}
