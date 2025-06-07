class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
                res[stack.pop()[0]] = nums[i];
            }
            stack.push(new int[]{i, nums[i]});
        }
        
        if(stack.isEmpty()) return res;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
                res[stack.pop()[0]] = nums[i];
            }
        }
        
        while(!stack.isEmpty()) {
            res[stack.pop()[0]] = -1;
        }
        return res;
    }
}