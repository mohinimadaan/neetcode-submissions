class Solution {

    public String encode(List<String> strs) {
        if(strs==null || strs.isEmpty()){
            return "";
        }

        StringBuilder build = new StringBuilder();
        for(String s : strs){
            build.append(s.length()).append("#").append(s);

        }
        return build.toString();

    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if(str==null || str.isEmpty()){
            return decoded;
        }

        int i = 0;
        while (i<str.length()){
            int hashPos = str.indexOf("#",i);

            int length = Integer.parseInt(str.substring(i,hashPos));

            int stringStart = hashPos+1;
            int stringEnd = stringStart + length;

            decoded.add(str.substring(stringStart,stringEnd));

            i = stringEnd;

        }
        return decoded;

    }
}
