class Solution {
    public String removeStars(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        String result = "";
        while (!stack.empty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}