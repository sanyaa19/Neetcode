class Solution {
    int[] pse(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    int[] nse(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[heights.length];

        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]) stack.pop();
            res[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] prev = pse(heights);
        int[] next = nse(heights);
        int max = 0;

        for(int i=0; i<heights.length; i++){
            max = Math.max(max , (next[i] - prev[i] - 1) * heights[i]);
        }

        return max;
    }
}
