class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //keeping sorted version as key
        Map<String,List<String>> hmap = new HashMap<>();

        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            hmap.computeIfAbsent(sorted, k-> new ArrayList<>()).add(s);

        }
        return new ArrayList<>(hmap.values());
        
    }
}
