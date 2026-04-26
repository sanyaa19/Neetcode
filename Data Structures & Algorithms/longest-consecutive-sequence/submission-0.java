class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n: nums){
            set.add(n);
        }

        int max=0;
        for(int num: nums){
            if(!set.contains(num-1)){
                
                int count=1;
                int current=num;

                while(set.contains(current+1)){
                    count++;
                    current++;
                }

                if(count>max) max=count;
            }
        }

        return max;
    }
}
