class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> frequency = new HashMap<>();
        //capture frequency of each city
        for(int i=0; i<roads.length; i++) {
            for(int j=0; j<roads[i].length; j++) {
                if (frequency.containsKey(roads[i][j])) {
                    int newVal = frequency.get(roads[i][j])+1;
                    frequency.put(roads[i][j], newVal);
                } else {
                    frequency.put(roads[i][j], 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(frequency.entrySet());
 
        // Sort the list descending
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, 
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap 
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> curr : list) {
            sortedMap.put(curr.getKey(), curr.getValue());
        }

        //assign number to cities
        for (Integer key : sortedMap.keySet()) {
            sortedMap.put(key, n);
            n--;
        }

        //get final num
        long res = 0;
        for(int i=0; i<roads.length; i++) {
            for(int j=0; j<roads[i].length; j++) {
                res = res + sortedMap.get(roads[i][j]);
            }
        }
        return res;
    }
}