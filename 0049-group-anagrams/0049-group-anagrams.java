class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> grouped = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String word : strs){
            char [] cur = word.toCharArray();
            Arrays.sort(cur);
            String key = new String(cur);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);
        }
        grouped.addAll(map.values());
        return grouped;
        
    }
}

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
//         List<List<String>> res = new ArrayList<>();

//         for (String str: strs) {
//             int[] alphabets = new int[26];
//             for (int i = 0; i < str.length(); i++) {
//                 int alphabet = str.charAt(i) - 'a';
//                 alphabets[alphabet]++;
//             }
//             String alphabetFrequency = Arrays.toString(alphabets);
//             if (map.containsKey(alphabetFrequency)) {
//                 List<String> group = map.get(alphabetFrequency);
//                 group.add(str);
//                 map.put(alphabetFrequency, group);
//             } else {
//                 List<String> group = new ArrayList<>();
//                 group.add(str);
//                 map.put(alphabetFrequency, group);
//             }
//         }

//         for (String alphabetFrequency: map.keySet()) {
//             res.add(map.get(alphabetFrequency));
//         }
//         return res;
//     }
// }