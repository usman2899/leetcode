class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int balloons = points.length;

        int prev = 0;
        int arrows = 1;

        for (int i = 1; i < balloons; i++) {
            if (points[i][0] > points[prev][1]) {
                arrows++;
                prev = i;
            }
        }
        return arrows;
    }
}