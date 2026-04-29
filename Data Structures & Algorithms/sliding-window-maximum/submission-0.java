class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int nWindow= nums.length - k + 1;
        int[] res = new int[nWindow];
        List<Integer> window = new ArrayList<>();

        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        boolean flag=false;

        int idx=0;

        while(right<nums.length){
            while(right<left+k){
                window.add(nums[right]);
                right++;
            }
            res[idx++]=Collections.max(window);
            window.remove(0);
            left++;
        }

        return res;
    }
}
