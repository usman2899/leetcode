class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        List<Integer> occurenceList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                cnt++;
                i++;
            }
            occurenceList.add(cnt);
        }

        Collections.sort(occurenceList);
        for (int i = 1; i < occurenceList.size(); i++) {
            if (occurenceList.get(i).equals(occurenceList.get(i - 1))) {
                return false;
            }
        }
        return true;
    }
}