class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i<=height.length-2; i++){
            if (i==0 || height[i] > height[i-1]){
                for (int j = height.length-1; j>=i+1; j--){
                    if (j==height.length-1 || height[j] > height[j+1]){
                        if (height[i] <= height[j]){
                            tempMax = height[i] * (j-i);
                            if (tempMax > max){
                                max = tempMax;
                            }
                            break;
                        }
                        else {
                            tempMax = height[j] * (j-i);
                            if (tempMax > max){
                                max = tempMax;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}