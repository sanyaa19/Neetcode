class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int nWindow= nums.length - k + 1;
        // int[] res = new int[nWindow];
        // List<Integer> window = new ArrayList<>();

        // int left=0;
        // int right=0;
        // int max=Integer.MIN_VALUE;

        // int idx=0;

        // while(right<nums.length){   O(n)
        //     while(right<left+k){    O(n)
        //         window.add(nums[right]);
        //         right++;
        //     }
        //     res[idx++]=Collections.max(window); O(n*K)
        //     window.remove(0);   O(n*k)
        //     left++;
        // }

        // return res;

        // //Not the best approach O(n*k) with higher n or k this would not work 
        // //on leetcode it didn't pass all testcases

        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        int left = 0;
        int right = 0;
        int idx = 0;

        while(right<nums.length){
            while(right<left+k){
                while(!q.isEmpty() && nums[right] > nums[q.peekLast()]) q.removeLast();

                q.add(right);
                right++;
            }
            res[idx++] = nums[q.peek()];

            if(q.peek()==left) q.remove();
            left++;
        }
        return res;
    }
}
