class Solution {
    public int maxArea(int[] heights) {
        int max=0;

        int left=0;
        int right=heights.length-1;
        int h=-1;
        int l=-1;

        while(left<right){
            if(heights[left]>=heights[right]){
                h=left;
                l=right;
            }
            else{
                l=left;
                h=right;
            }
            int wtr=(right-left)*heights[l];
            if(wtr>max) max=wtr;

            if(heights[left]>=heights[right]){
                right--;
            }
            else{
                left++;
            }

        }
        return max;
    }
}
