class Solution {
    List<String> res;
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        res = new ArrayList<>();
        Set<String> suppliesSet = new HashSet<>();
        for (String supply : supplies) {
            suppliesSet.add(supply);
        }

        Map<String, List<String>> recipeAdjList = new HashMap<>();
        int totalRecipes = recipes.length;
        for (int i = 0; i < totalRecipes; i++) {
            recipeAdjList.put(recipes[i], ingredients.get(i));
        }
        
        Map<String, Boolean> recipesMemo = new HashMap<>();
        Set<String> visiting = new HashSet<>(); // To detect cycles
        
        for (String recipe : recipes) {
            if (dfs(recipe, suppliesSet, recipesMemo, recipeAdjList, visiting)) {
                res.add(recipe);
            }
        }
        
        return res;
    }

    boolean dfs(String recipe, Set<String> suppliesSet, Map<String, Boolean> recipesMemo, 
                Map<String, List<String>> recipeAdjList, Set<String> visiting) {
        
        if (recipesMemo.containsKey(recipe)) {
            return recipesMemo.get(recipe);
        }
        
        if (suppliesSet.contains(recipe)) {
            recipesMemo.put(recipe, true);
            return true;
        }
        
        if (!recipeAdjList.containsKey(recipe)) {
            recipesMemo.put(recipe, false);
            return false;
        }
        
        if (visiting.contains(recipe)) {
            recipesMemo.put(recipe, false);
            return false;
        }
        
        visiting.add(recipe);
        
        List<String> ingredientsList = recipeAdjList.get(recipe);
        for (String ingredient : ingredientsList) {
            if (!dfs(ingredient, suppliesSet, recipesMemo, recipeAdjList, visiting)) {
                visiting.remove(recipe);
                recipesMemo.put(recipe, false);
                return false;
            }
        }
        
        visiting.remove(recipe);
        recipesMemo.put(recipe, true);
        return true;
    }
}