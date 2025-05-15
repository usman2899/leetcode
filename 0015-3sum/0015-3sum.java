class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int currIndex = 0; currIndex < len - 2; currIndex++) {
            if (currIndex > 0 && nums[currIndex] == nums[currIndex-1]) {
                continue;
            }
            int currNum = nums[currIndex];

            int startIndex = currIndex+1;
            int endIndex = len-1;
            while (startIndex < endIndex) {
                int startNum = nums[startIndex];
                int endNum = nums[endIndex];
                int sum = currNum + startNum + endNum;
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(currNum, startNum, endNum)));
                    startIndex++;
                    endIndex--;
                    while (startIndex < endIndex && startNum == nums[startIndex]) {
                        startIndex++;
                    }
                    while (startIndex < endIndex && endNum == nums[endIndex]) {
                        endIndex--;
                    }
                } else if (sum > 0) {
                    endIndex--;
                } else {
                    startIndex++;
                }
            }
        }
        return res;
    }
}