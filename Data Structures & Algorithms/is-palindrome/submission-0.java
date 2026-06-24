class Solution {
    public boolean isPalindrome(String s) {

        String cleanedS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = cleanedS.length()-1;
        while(start < end){
            char lowerStart = Character.toLowerCase(cleanedS.charAt(start));
            char lowerEnd = Character.toLowerCase(cleanedS.charAt(end));
            if(lowerStart != lowerEnd){
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
}
