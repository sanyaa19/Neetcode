class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer > map1 = new HashMap<>();
        HashMap<Character , Integer > map2 = new HashMap<>();

        for(char c : s1.toCharArray()) map1.put(c,map1.getOrDefault(c,0)+1);
        
        int left=0;
        int right=0;

        while(right<s2.length()){
            // if(map1.containsKey(left)){
            //     if(right<left) left=right;
            
            while(right<s2.length() && right < left + s1.length()){  //expand
                char c = s2.charAt(right);
                map2.put(c,map2.getOrDefault(c,0)+1);
                right++;
            }

            if(map2.equals(map1)) return true;
            //while(left<right && (!map1.containsKey(left) || map1.get(left)!=map2.get(left))){
            // if(left<right){
            char c = s2.charAt(left);
            map2.put(c,map2.getOrDefault(c,0)-1);
            if(map2.get(c) == 0) map2.remove(c);
                //}
            left++; //shrink
        }
        return false;
    }
}
