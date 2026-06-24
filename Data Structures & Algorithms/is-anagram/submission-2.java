class Solution {
    public boolean isAnagram(String s, String t) {
        //Sorting
        //if(s.length() != t.length()){
            //return false;
        //}

        //char[] sChar = s.toCharArray();
        //char[] tChar = t.toCharArray();
        //Arrays.sort(sChar);
        //Arrays.sort(tChar);

        //return Arrays.equals(sChar,tChar);

        //HashMap
        //if(s.length() != t.length()){
            //return false;
        //}

        //HashMap<Character,Integer> sMap = new HashMap<>();
        //HashMap<Character,Integer> tMap = new HashMap<>();
        //for(int i = 0 ;i< s.length(); i++){
            //sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            //tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        //}

        //return sMap.equals(tMap);


        //HashTable using array
        if(s.length() != t.length()){
            return false;
        }
        int[] intArr = new int[26];

        for(int i = 0 ;i< s.length(); i++){
            intArr[s.charAt(i)-'a']++;
            intArr[t.charAt(i)-'a']--;
        }

        for (int j : intArr){
            if (j != 0){
                return false;
            }
        }
        return true;

    }
}
