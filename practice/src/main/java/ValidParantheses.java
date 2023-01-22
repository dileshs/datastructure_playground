package main.java;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("({[]}){}(("));
    }

    /*private static boolean isValid(String s) {
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
}
