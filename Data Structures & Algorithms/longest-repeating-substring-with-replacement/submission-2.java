class Solution {
    public int characterReplacement(String s, int k) {

        //brute force
        //int res = 0;
        
        //for(int i = 0; i< s.length(); i++){
            //Map<Character,Integer> mp = new HashMap<>();
            //int maxF = 0;
            //for(int j = i; j < s.length(); j++){
                //char ch = s.charAt(j);
                //mp.put(ch, mp.getOrDefault(ch,0)+1);
                //maxF = Math.max(maxF, mp.get(ch));
                //if( (j-i+1)-maxF <= k){
                    //res = Math.max(res, j-i+1);
                //}
            //}
        //}
        //return res;

        //sliding window

        int start = 0;
        int end = 0;
        int maxLength = 0;
        int maxF = 0;
        Map<Character,Integer> hm = new HashMap<>();
        while (end < s.length()){
            //do calculations
            char ch = s.charAt(end);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            maxF = Math.max(maxF,hm.get(ch));
            if((end-start+1)-maxF <= k){
                //calculate ans;
                maxLength = Math.max(maxLength, end-start+1);
                end++;
            }else{
                //slide window
                //remove calculations of start;
                char cl = s.charAt(start);
                hm.put(cl,hm.get(cl)-1);
                if(hm.get(cl)==0){
                    hm.remove(cl);
                }
                start++;
                end++;
            }
        }
        return maxLength;
        
    }
}
