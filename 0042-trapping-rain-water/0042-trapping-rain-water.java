class Solution {
    public int trap(int[] height) {
        int bars = height.length;
        int res = 0;
        if (bars < 3) return res;
        
        int[] leftMax = new int[bars];
        int[] rightMax = new int[bars];

        int max = -1;
        for (int i = 1; i < bars-1; i++) {
            max = Math.max(max, height[i-1]);
            leftMax[i] = max;
        }
        max = -1;
        for (int i = bars-2; i > 0; i--) {
            max = Math.max(max, height[i+1]);
            rightMax[i] = max;
        }

        for (int i = 1; i < bars-1; i++) {
            int waterAtI = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (waterAtI > 0) res += waterAtI; 
        }
        return res;

    }
}
//         /*
//         Sliding window
//         if taller restart
//         */
        

//         int startIndex = 0;
//         int startHeight = 0;
        
//         while (startIndex < bars) {
//             if (height[startIndex] > 0) {
//                 startHeight = height[startIndex++];
//                 break;
//             }
//             startIndex++;
//         } 
        
//         for (int i = startIndex; i < bars; i++) {
//             if (height[i] >= startHeight) {
//                 res += subArrayRainCalculator(height, startHeight, startIndex, i);
//                 startIndex = i;
//             }
//         }
//         return res;
//     }

//     int subArrayRainCalculator (int[] height, int minHeight, int startIndex, int endIndex) {
//         int rain = 0;
//         for (int i = startIndex; i < endIndex; i++) {
//             int waterHere = minHeight - height[i]; 
//             rain += waterHere;
//         }
//         return rain;
//     }
// }