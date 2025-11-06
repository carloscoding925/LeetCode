package Java.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_ValidParenthesis {
    public static void main(String[] args) {
        System.out.println("#20 - Valid Parenthesis - Easy");

        String input = "([{}])";
        boolean valid = isValid(input);

        System.out.println("Valid Parenthesis: " + valid);

        return;
    }

    private static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        Map<Character, Character> closers = new HashMap<>();
        closers.put('}', '{');
        closers.put(')', '(');
        closers.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);

            if (!closers.containsKey(nextChar)) {
                charStack.push(nextChar);
            }
            else {
                if (charStack.isEmpty() || charStack.peek() != closers.get(nextChar)) {
                    return false;
                }
                
                charStack.pop();
            }
        }

        return charStack.isEmpty();
    }
}
