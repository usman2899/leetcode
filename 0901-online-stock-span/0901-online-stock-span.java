class StockSpanner {
    Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        stack.push(new int[] {price, res});
        return res;
    }
}
//     Stack<Integer> actual;
    
//     public StockSpanner() {
//         actual = new Stack<>();
//     }
    
//     public int next(int price) {
//         int res = 1;
//         Stack<Integer> temp = (Stack<Integer>)actual.clone();
//         while (!temp.isEmpty() && temp.peek() <= price) {
//             temp.pop();
//             res++;
//         }
//         actual.push(price);
//         return res;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */