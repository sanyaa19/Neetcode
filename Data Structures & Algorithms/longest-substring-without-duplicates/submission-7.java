class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        int max=0;

        for(int i=0; i<s.length(); i++){
            HashSet<Character> set =new HashSet<>();
            int count=0;
            for(int j=i; j<s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    count++;
                }
                else break;
            }
            if(count>max) max=count;
        }
        return max;

        //Brute force approach O(n^2)
        */

        if(s.length()==1) return 1;
        HashMap<Character, Integer> map = new HashMap<>();

        int left=-1; //store left window index
        int count=0;
        int max=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c) && map.get(c)>left){
                
                left=map.get(c); 
                //left side of window jumps to the index which just got canceled 
                //now we will look at indexes greater than this index for duplicates
                if(count>max) max=count;

                count = i - left;

            }

            else count++;

            map.put( c , i);
            
            //value doesn't then it'd added to map 
            //but if it exists it's still added to update the index value
        }

        if(count > max) max = count;
        
        return max;

    }
}
