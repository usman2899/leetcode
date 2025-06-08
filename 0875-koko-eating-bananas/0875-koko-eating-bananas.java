class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = findMax(piles);

        while (min <= max) {
            int speed = min + (max-min)/2;
            if (canFinish(piles, speed, h)) {
                max = speed - 1;
            } else {
                min = speed + 1;
            }
        }
        return min;
    }

    boolean canFinish(int[] piles, int speed, long givenHours) {
        long actualHours = 0;
        for (int pile: piles) {
            actualHours += (pile + speed - 1)/speed;
        }
        return actualHours <= givenHours;
    }

    int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}