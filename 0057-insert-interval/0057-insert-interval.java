class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        boolean overlaps = false;

        for(int[] interval: intervals) {
            if (interval[1] < newInterval[0]) {
                resList.add(interval);
            } else if (newInterval[1] < interval[0]){
                resList.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        resList.add(newInterval);

        return resList.toArray(new int[resList.size()][]);
    }
}