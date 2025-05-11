class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        recursion(new StringBuilder(), 0, 0, n);
        return result;
    }

    void recursion (StringBuilder curr, int open, int close, int n) {
        if (n == open && n == close) {
            result.add(curr.toString());
            return;
        } else {
            if (open < n) {
                recursion(curr.append("("), open+1, close, n);
                curr.deleteCharAt(curr.length()-1);
            }
            if (close < open) {
                recursion(curr.append(")"), open, close+1, n);
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}

// class Solution {
//     List<String> result;

//     public List<String> generateParenthesis(int n) {
//         result = new ArrayList<>();
//         backtrack("", 0, 0, n);
//         return result;
//     }

//     void backtrack(String curr, int open, int close, int n) {
//         if (open == n && close == n) {
//             result.add(curr);
//             return;
//         }

//         if (open < n) {
//             backtrack(curr + "(", open + 1, close, n);
//         }

//         if (close < open) {
//             backtrack(curr + ")", open, close + 1, n);
//         }
//     }
// }
