class Solution {
    public int characterReplacement(String s, int k) {
        
        ArrayList<Integer> list = new ArrayList<>(26);
        for(int i=0; i<26; i++) list.add(0);

        int max=0;
        int left=0;
        int idx=s.charAt(left)%65;  //A=65
        list.set(idx , list.get(idx)+1);

        for(int right = left+1 ; right <s.length(); right++){
            idx=s.charAt(right)%65;
            list.set(idx , list.get(idx)+1);

            int distinct = (right-left+1) - Collections.max(list);
            //no of distinct elements = subarray length - freq of alphabet with max freq in subarray
                
            while(distinct>k){
                idx=s.charAt(left)%65;  
                list.set(idx , list.get(idx)-1);
                left++;

                distinct = (right-left+1) - Collections.max(list);
            }
            

            max = Math.max(max , right - left +1);
        }
        return max;
    }
}
