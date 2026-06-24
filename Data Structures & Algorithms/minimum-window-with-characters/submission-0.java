class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }
        int countTSize = countT.size();

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        int start = 0;
        int end = 0;
        while(end < s.length()){

            //calculations for end 
            char ch = s.charAt(end);
            if(countT.containsKey(ch)){
                countT.put(ch,countT.get(ch)-1);
                if(countT.get(ch)==0){
                    countTSize--;
                }
            }


            if(countTSize == 0){//all characters found
                while(countTSize==0){//shrink from left
                    if(end-start+1 < minLen){
                        minLen = end-start+1;
                        startIdx = start;
                    }

                    //remove calculations of start
                    char cs = s.charAt(start);
                    if(countT.containsKey(cs)){
                        if(countT.get(cs)==0){
                            countTSize++;
                        }
                        countT.put(cs,countT.get(cs)+1);
                    }
                    start++;
                }
                end++;
            }else{
                end++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx,startIdx+minLen);
}
}
