class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int N = s.length();
        Map<Character,Integer> map = new HashMap<>();

        while(end < N){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);

            if(map.size() == end-start+1){ // means no duplicate so can be ans
                maxLen = Math.max(maxLen, end-start+1);
                end++;

            }else if (map.size() < end-start+1){ // means duplicate chars
                //remove calculations of start
                while(map.size() < end-start+1){
                    char ch = s.charAt(start);
                    if(map.get(ch)==1){ //either remove or decrement count
                        map.remove(ch);
                    }else{
                        map.put(ch,map.get(ch)-1);
                    }
                    start++;
                }
                end++;

            }else if (map.size() > end-start+1){ //wont happen

            }

        }

        return maxLen;
        
    }
}
