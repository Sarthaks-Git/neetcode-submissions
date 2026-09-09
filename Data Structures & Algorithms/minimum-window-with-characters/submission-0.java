class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int requiredCount=t.length();
        int i=0,j=0;
        int minWindowSize=Integer.MAX_VALUE;
        int start_i=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.getOrDefault(ch,0) > 0){
                requiredCount--;
            }
            map.put(ch,map.getOrDefault(ch,0)-1);

            while(requiredCount == 0){
                // shrink the window
                int currWindowsSize=j-i+1;
                if(currWindowsSize < minWindowSize){
                    minWindowSize=currWindowsSize;
                    start_i=i;
                }

                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                if(map.getOrDefault(s.charAt(i),0) > 0){
                    requiredCount++;
                }
                i++;
            }

            j++;
        }
        if(minWindowSize == Integer.MAX_VALUE) return "";
        return s.substring(start_i,start_i+minWindowSize);
    }

}
