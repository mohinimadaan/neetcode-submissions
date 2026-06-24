class Solution {
    public int characterReplacement(String s, int k) {

        //brute force
        int res = 0;
        
        for(int i = 0; i< s.length(); i++){
            Map<Character,Integer> mp = new HashMap<>();
            int maxF = 0;
            for(int j = i; j < s.length(); j++){
                char ch = s.charAt(j);
                mp.put(ch, mp.getOrDefault(ch,0)+1);
                maxF = Math.max(maxF, mp.get(ch));
                if( (j-i+1)-maxF <= k){
                    res = Math.max(res, j-i+1);
                }
            }

        }
        return res;
        
    }
}
