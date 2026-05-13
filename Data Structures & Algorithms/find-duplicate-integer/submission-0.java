class Solution {
    public int findDuplicate(int[] nums) {
        // Brute force -> nested loops time O(n)  space O(1)
        // better -> sort arrays then check if(nums[i] == nums[i+1]) 
        // time O(n log n)  space O(1 or log n)

        // better-> hashset time O(n)  space O(n)

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            if(set.contains(n)) return n;
            set.add(n);
        }

        return 0;
    }
}
