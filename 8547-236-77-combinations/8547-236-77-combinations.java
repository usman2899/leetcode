// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> combine(int n, int k) {
//         res = new ArrayList<>();
//         recurse(new ArrayList<>(), k, n, 1);
//         return res;
//     }

//     void recurse (List<Integer> curr, int k, int n, int start) {
//         if (curr.size() == k) {
//             res.add(new ArrayList<>(curr));
//             return;
//         } else {
//             for (int i = start; i <= n; i++) {
//                 curr.add(i);
//                 recurse(curr, k, n, i+1);
//                 curr.remove(curr.size()-1);
//             }
//         }
//     }
// }

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        recurse(new ArrayList<>(), k, n, 1);
        return res;
    }

    void recurse (List<Integer> curr, int k, int n, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else {
            for (int i = start; i <= n; i++) {
                curr.add(i);
                recurse(curr, k-1, n, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}