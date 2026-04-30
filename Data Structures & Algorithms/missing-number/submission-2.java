class Solution {
    public int missingNumber(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<=nums.length; i++){
        //     map.put(i,0);
        // }
        // for(int n : nums){
        //     map.put(n,1);
        // }
        // for(int i=0; i<=nums.length; i++){
        //     if(map.get(i)==0)
        //     return i;
        // }
        // return -1;


        //int totalSum=0;
        int arraySum=0;
        // for(int i=0; i<=nums.length; i++){
        //     totalSum += i;
        // }
        int totalSum = nums.length*(nums.length+1)/2;
        for(int n : nums){
            arraySum += n;
        }
        return (totalSum - arraySum);
    }
}
