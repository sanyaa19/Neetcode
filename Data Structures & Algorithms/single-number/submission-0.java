class Solution {
    public int singleNumber(int[] nums) {
        int sl = nums[0];

        for(int i=1; i<nums.length; i++) sl^=nums[i];

        return sl;
    }
}
