class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        
        while (left <= right) {
            int mid = left + ((right-left)/2);
            boolean finish = canFinish(piles, h, mid);
            if (finish) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    boolean canFinish(int[] piles, int maxHours, int k) {
        int actualHours = 0;
        
        for (int pile: piles) {
            actualHours += (pile + k - 1) / k; 
            if (actualHours > maxHours) {
                return false;
            }
        }
        return actualHours <= maxHours;
    }
    
    int max(int[] arr) {
        int max = -1;
        for (int num: arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
}