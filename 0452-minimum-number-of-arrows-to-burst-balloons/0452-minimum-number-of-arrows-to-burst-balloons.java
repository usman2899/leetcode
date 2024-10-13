class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int res = 1;
        int start = points[0][0];
        int end = points[0][1];
        int len = points.length;
        
        for (int i = 1; i < len; i++) {
            if (points[i][0] == start && points[i][1] < end) {
                end = points[i][1];
            }
            else if (points[i][0] != start && points[i][0] > end){
                res++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return res;
    }
}