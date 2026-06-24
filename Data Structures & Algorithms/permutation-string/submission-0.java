class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character,Integer> hm = new HashMap<>();
        for(char c : s1.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int count = hm.size();

        int start = 0;
        int end = 0;
        while(end < s2.length()){
            //do calculations
            char eCh = s2.charAt(end);
            if(hm.containsKey(eCh)){
                hm.put(eCh, hm.get(eCh)-1);
                if(hm.get(eCh)==0){
                    count--;
                }
            }

            if(end-start+1 < s1.length()){
                end++;
            }else if (end-start+1 == s1.length()){
                if(count==0){
                    return true;
                }
                
                //remove calculations of start
                char sCh = s2.charAt(start);
                if(hm.containsKey(sCh)){
                    if(hm.get(sCh)==0){
                        count++;
                    }
                    hm.put(sCh,hm.get(sCh)+1);
                }
                start++;
                end++;
            }
        }
        return false;
        
    }
}
