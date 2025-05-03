// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         Stack<int[]> stack = new Stack<>();
        
//         for (int i = temperatures.length-1; i >= 0; i--) {
//             int curr = temperatures[i];
//             while (!stack.isEmpty() && stack.peek()[0] <= curr) {
//                 stack.pop();
//             }
//             if (stack.isEmpty()) {
//                 stack.push(new int[]{curr, i});
//                 temperatures[i] = 0;
//             } else {
//                 int diff = stack.peek()[1] - i;
//                 stack.push(new int[]{curr, i});
//                 temperatures[i] = diff;
//             }
//         }
//         return temperatures;
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        
        for (int i = len-1; i >= 0; i--) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] <= curr) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int diff = stack.peek()[1] - i;
                res[i] = diff;
            }
            stack.push(new int[]{curr, i});
        }
        return res;
    }
}