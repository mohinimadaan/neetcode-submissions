class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Using hashmap and then ordering it based on freq/value
        int[] res = new int[k];
        Map<Integer,Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }

        Map<Integer,Integer> orderedCount = new LinkedHashMap<>();
        count.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(e -> orderedCount.put(e.getKey(),e.getValue()));

        int counter = 0;
        for(int j : orderedCount.keySet()){
            res[counter] =  j;
            counter++;
            if(counter==k){
                break;
            }      
         }



        return res;
        
    }
}
