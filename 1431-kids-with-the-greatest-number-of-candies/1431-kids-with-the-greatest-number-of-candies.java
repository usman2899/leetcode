class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = 0;
        int len = candies.length;
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(candies[i] > largest) {
                largest = candies[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if((candies[i] + extraCandies) >= largest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}