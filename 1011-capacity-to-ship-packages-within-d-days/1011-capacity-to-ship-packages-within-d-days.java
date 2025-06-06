class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 1;
        int max = 0;
        for (int weight: weights) {
            max += weight;
        }

        while (min <= max) {
            int capacity = min + (max-min)/2;
            int currDays = 1, currShipLoad = 0; 
            

            for (int i = 0; i < weights.length; i++) {
                int currWeight = weights[i];

                if (currWeight > capacity) {
                    currDays = days+1;
                    break;
                }
                if (currShipLoad + currWeight > capacity) {
                    currDays++;
                    currShipLoad = currWeight;
                } else {
                    currShipLoad += currWeight;
                }

                if (currDays > days) break;
            }

            if (currDays <= days) {
                max = capacity-1;
            } else {
                min = capacity+1;
            }
        }
        return min;
    }
}