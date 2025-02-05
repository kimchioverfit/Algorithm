/**
 * https://leetcode.com/problems/valid-parentheses/submissions/1524359342/
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();
                if (!((p == '(' && c == ')')
                        || (p == '{' && c == '}')
                        || (p == '[' && c == ']'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}