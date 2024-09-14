class Solution {
    public int findCircleNum(int[][] isConnected) {
        int total = isConnected.length;
        boolean[] visited = new boolean[total];
        int result = 0;
        
        //Traverse all cities
        for (int i = 0; i < total; i++) {
            
            //Skip city if visited
            if (visited[i] == true) continue;
            
            //New province
            result++;
            
            //DFS this province
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while(!stack.isEmpty()){
                int currentCity = stack.pop();
                visited[currentCity] = true;
                
                for (int j = 0; j < total; j++) {
                    if (visited[j] == true) continue;
                    if (isConnected[currentCity][j] == 1) stack.push(j);
                }
            }
        }
        return result;
    }
}