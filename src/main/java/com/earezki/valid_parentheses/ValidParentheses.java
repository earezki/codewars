package com.earezki.valid_parentheses;

import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        List<Character> opening = List.of('(', '[', '{');
        List<Character> closing = List.of(')', ']', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (opening.contains(c)) {
                stack.push(c);
            }

            if (closing.contains(c) && stack.isEmpty()) {
                return false;
            }

            if (closing.contains(c)) {
                char last = stack.pop();

                if (closing.indexOf(c) != opening.indexOf(last)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
