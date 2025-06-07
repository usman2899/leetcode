class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0,i);
            List<String> suggestions = new ArrayList<>();
            int count = 0;

            for (String product: products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                    count++;
                }
                if (count == 3) break;
            }
            result.add(suggestions);
        }
        return result;
    }
}