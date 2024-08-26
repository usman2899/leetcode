class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
            for (int i = nums.length-2; i>=0; i--) {
                for (int j = nums.length-1; j>i ; j--){
                    if (nums[i] < nums[j]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums,i+1,nums.length);
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
                if (i==0){
                    Arrays.sort(nums); 
                }
                
            }
    }
}