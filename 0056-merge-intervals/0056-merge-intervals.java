class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> resList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart <= end) {
                if (currEnd > end) {
                    end = currEnd;
                }
            } else {
                resList.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        resList.add(new int[]{start, end});
        int[][] resArray = resList.toArray(new int[resList.size()][]);
        return resArray;
    }
}