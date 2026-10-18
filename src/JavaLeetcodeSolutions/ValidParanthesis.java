package JavaLeetcodeSolutions;

import java.util.Stack;

public class ValidParanthesis {
    static class ValidParenthesis {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty())
                        return false;

                    char top = stack.pop();
                    if ((ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[')) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

    }

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();

        System.out.println(obj.isValid("()"));      // true
        System.out.println(obj.isValid("()[]{}"));  // true
        System.out.println(obj.isValid("(]"));      // false
        System.out.println(obj.isValid("([)]"));    // false
        System.out.println(obj.isValid("{[]}"));    // true
    }
}