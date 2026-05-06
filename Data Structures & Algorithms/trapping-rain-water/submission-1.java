class Solution {
    public int trap(int[] height) {
        /*
        //Optimal approach O(n)->Time O(1)->Space

        int left = 0 ;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        while(left<right){
            if(height[left] <= height[right]){
                if(height[left]>=leftMax) leftMax = height[left];
                else total += leftMax - height[left];
                left++;
            }
            else{
                if(height[right]>=rightMax) rightMax = height[right];
                else total += rightMax - height[right];
                right--;
            }
        }
        return total;
        */


        //Prefix Suffix max O(n)->Time O(n)->Space

        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        int n = height.length-1;
        int total = 0;

        prefix[0]=height[0];
        suffix[n] = height[n];

        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1] , height[i]);
            suffix[n-i] = Math.max(suffix[n-i+1] , height[n-i]);        
            //we can run 2 seperate loops also for. for suffix from height.length-2 -> 0
        }

        for(int i=1; i<n; i++){
            total += Math.min(prefix[i] , suffix[i]) - height[i];
        }

        return total;

    }
}
