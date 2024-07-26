class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean result = true;
        Set<Integer> allKeys = new HashSet<>(rooms.get(0));
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));

        while (!stack.isEmpty()) {
            int key = stack.pop();
            List<Integer> thisRoomKeys = rooms.get(key);
            for(Integer thisRoomKey : thisRoomKeys) {
                if (!allKeys.contains(thisRoomKey)) {
                    stack.push(thisRoomKey);
                    allKeys.add(thisRoomKey);
                }
            }
        }
        allKeys.add(0);
        return allKeys.size() == rooms.size();

        // for (int i = 1; i < rooms.size(); i++) {
        //     if (!allKeys.contains(i)) {
        //         result = false;
        //         break;
        //     }
        // }
        // return result;
    }
}