class Solution {
    public int findDuplicate(int[] nums) {
        // Brute force -> nested loops time O(n^2)  space O(1)
        // better -> sort arrays then check if(nums[i] == nums[i+1]) 
        // time O(n log n)  space O(1 or log n)

        // better-> hashset time O(n)  space O(n)

        // HashSet<Integer> set = new HashSet<>();

        // for(int n : nums){
        //     if(set.contains(n)) return n;
        //     set.add(n);
        // }

        // return 0;

        //optimal solution -> time O(n)  space O(1)
        //floyds algorithm tortoise & hare 
        //we will conside duplicates as same node 
        //meaning if there is duplicate then there is a loop


        int slow = nums[0];
        int fast = nums[0];

        // Detect cycle
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // Find cycle entry
        fast = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}