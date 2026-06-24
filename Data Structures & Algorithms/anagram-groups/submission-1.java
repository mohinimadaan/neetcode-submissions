class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //keeping sorted version of each string as key
        //Map<String,List<String>> hmap = new HashMap<>();

        //for(String s : strs){
            //char[] charArr = s.toCharArray();
            //Arrays.sort(charArr);
            //String sorted = new String(charArr);
            //hmap.computeIfAbsent(sorted, k-> new ArrayList<>()).add(s);

        //}
        //return new ArrayList<>(hmap.values());

        ////instead of sorting every string, we will use count array 
        //to represent freq of characters in string
        Map<String,List<String>> hmap = new HashMap<>();
        for(String s : strs){
            int[] countArr = new int[26];
            for(char c : s.toCharArray()){
                countArr[c-'a']++;
            }
            String key = Arrays.toString(countArr);
            hmap.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hmap.values());


        
    }
}
