class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(asteroid);
                }

                if (stack.peek() == -asteroid) {
                    stack.pop();
                } 
            }
        }

        int len = stack.size();
        int[] res = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}