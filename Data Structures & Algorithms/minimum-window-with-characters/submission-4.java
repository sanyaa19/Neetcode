class Solution {

    public boolean isValid(HashMap<Character, Integer> mapT , HashMap<Character, Integer> mapS){
        for(char c : mapT.keySet()){
            if(!mapS.containsKey(c) || mapS.get(c) < mapT.get(c)) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();

        for(char c : t.toCharArray()) mapT.put(c , mapT.getOrDefault(c , 0) +1);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = s.length()-1;
        boolean noSubstring = true;

        while(right < s.length()){

            char c = s.charAt(right);
            if(mapT.containsKey(c)){
                mapS.put(c , mapS.getOrDefault(c , 0) +1);
            }

            while(isValid(mapT , mapS)  && left<=right){
                
                noSubstring = false;

                if(min > right - left + 1){
                    min = right - left + 1;
                    leftIdx = left;
                    rightIdx = right;
                }

                c = s.charAt(left);
                if(mapS.containsKey(c)){
                    mapS.put(c , mapS.get(c) - 1);
                    if(mapS.get(c) == 0) mapS.remove(c);
                }

                left++;
            }

            right++;
        }

        if(noSubstring) return "";
        else return s.substring(leftIdx,rightIdx+1);
    }
}
