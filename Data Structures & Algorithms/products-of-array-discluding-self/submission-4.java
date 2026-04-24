class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount=0;
        int zeroIdx=-1;
        
        for(int i=0; i< nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
                zeroIdx=i;
            }
        }
        
        int product=1;

        if(zeroCount<2){
            for(int i=0; i<nums.length; i++){
                if(i!=zeroIdx) product *= nums[i];
                else continue;
            }
        }
        
        int[] res = new int[nums.length];

        if(zeroCount==0){
            for(int i=0; i<nums.length; i++){
                res[i]= product/nums[i];
            }
        }

        else if(zeroCount==1){
            res[zeroIdx]=product;
        }

        return res;
    }
}  
