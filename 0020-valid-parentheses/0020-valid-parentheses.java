class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char curr: s.toCharArray()) {
            if (curr == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (curr == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (curr == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }
}