class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean flag = false;
            int ast = asteroids[i];

            while (!flag) {
                int top = 0;
                if (!stack.isEmpty()) {
                    top = stack.peek();
                }
                if (stack.isEmpty() || (top > 0 && ast > 0) || (top < 0 && ast < 0) || (top < 0 && ast > 0)) {
                    stack.push(ast);
                    flag = true;
                } else {
                    if (top > Math.abs(ast)) {
                        flag = true;
                    } else if (top == Math.abs(ast)) {
                        stack.pop();
                        flag = true;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        int stackSize = stack.size();
        int[] res = new int[stackSize];
        for (int i = 0; i < stackSize; i++) {
            res[i] = stack.get(i);
        }            
        return res;
    }
}