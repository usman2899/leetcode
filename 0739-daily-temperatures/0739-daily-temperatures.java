class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int stackIndex = stack.pop();
                int difference = i - stackIndex;
                res[stackIndex] = difference;
            }
            stack.push(i);
        }
        return res;
    }
}